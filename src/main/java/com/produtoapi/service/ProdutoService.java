package com.produtoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtoapi.model.Produto;
import com.produtoapi.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    // 🔹 Salvar ou atualizar produto
    public Produto salvar(Produto produto) {
        // Evita erro de ID manualmente definido (SQLite exige autoincrement)
        if (produto.getId() != null && produto.getId() <= 0) {
            produto.setId(null);
        }
        return repository.save(produto);
    }

    // 🔹 Buscar todos os produtos
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    // 🔹 Buscar produto por ID
    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // 🔹 Excluir produto
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    // 🔹 Atualizar lista completa (se usado no frontend)
    public void salvarLista(List<Produto> produtos) {
        for (Produto p : produtos) {
            if (p.getId() != null && p.getId() <= 0) {
                p.setId(null);
            }
        }
        repository.saveAll(produtos);
    }
}
