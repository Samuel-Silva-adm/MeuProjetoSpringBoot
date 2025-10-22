package com.produtoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeuProjetoSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuProjetoSpringbootApplication.class, args);
	}

}


/*
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Gerenciamento de Produtos</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 40px;
      background-color: #f9f9f9;
    }

    h1 {
      text-align: center;
      color: #333;
    }

    form {
      display: flex;
      justify-content: center;
      gap: 10px;
      margin-bottom: 20px;
    }

    input, button {
      padding: 8px 10px;
      font-size: 15px;
    }

    button {
      cursor: pointer;
      border: none;
      border-radius: 4px;
    }

    #btnAdd {
      background-color: #4CAF50;
      color: white;
    }

    #btnAdd:hover {
      background-color: #45a049;
    }

    .btnEditar {
      background-color: #2196F3;
      color: white;
    }

    .btnEditar:hover {
      background-color: #0b7dda;
    }

    .btnExcluir {
      background-color: #f44336;
      color: white;
    }

    .btnExcluir:hover {
      background-color: #da190b;
    }

    table {
      width: 80%;
      margin: 0 auto;
      border-collapse: collapse;
      background: #fff;
      box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }

    th, td {
      padding: 10px 15px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #4CAF50;
      color: white;
    }

    tr:hover {
      background-color: #f1f1f1;
    }

    #total {
      text-align: center;
      margin-top: 20px;
      font-size: 18px;
      font-weight: bold;
      color: #333;
    }
  </style>
</head>
<body>
  <h1>Gerenciamento de Produtos</h1>

  <!-- 🟩 Formulário para adicionar ou editar -->
  <form id="formProduto">
    <input type="hidden" id="produtoId">
    <input type="text" id="nome" placeholder="Nome do produto" required>
    <input type="number" step="0.01" id="preco" placeholder="Preço" required>
    <button type="submit" id="btnAdd">Adicionar Produto</button>
  </form>

  <!-- 🧾 Tabela -->
  <table id="tabelaProdutos">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Preço (R$)</th>
        <th>Ações</th>
      </tr>
    </thead>
    <tbody></tbody>
  </table>

  <div id="total">Total de produtos: 0</div>

  <script>
    const tabela = document.querySelector("#tabelaProdutos tbody");
    const total = document.getElementById("total");
    const form = document.getElementById("formProduto");
    const btnAdd = document.getElementById("btnAdd");

   // const API_URL = "http://localhost:8080/produtos"; // ✅ BACKEND URL
	const API_URL = "/produtos"; // ✅ BACKEND URL
	
	
    // 🔄 Carregar produtos
    function carregarProdutos() {
      fetch(API_URL)
        .then(res => res.json())
        .then(produtos => {
          tabela.innerHTML = '';
          produtos.forEach(produto => {
            const linha = document.createElement("tr");
            linha.innerHTML = `
              <td>${produto.id}</td>
              <td>${produto.nome}</td>
              <td>${produto.preco.toFixed(2)}</td>
              <td>
                <button class="btnEditar" onclick="editarProduto(${produto.id}, '${produto.nome}', ${produto.preco})">Editar</button>
                <button class="btnExcluir" onclick="deletarProduto(${produto.id})">Excluir</button>
              </td>
            `;
            tabela.appendChild(linha);
          });
          total.textContent = `Total de produtos: ${produtos.length}`;
        })
        .catch(err => console.error('Erro ao carregar produtos:', err));
    }

    // 🟩 Adicionar ou Atualizar Produto
    form.addEventListener('submit', function (event) {
      event.preventDefault();

      const id = document.getElementById('produtoId').value;
      const nome = document.getElementById('nome').value;
      const preco = parseFloat(document.getElementById('preco').value);
      const produto = { nome, preco };

      if (id) {
        // Atualizar (PUT)
        fetch(`${API_URL}/${id}`, {
          method: 'PUT',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(produto)
        })
          .then(res => {
            if (!res.ok) throw new Error('Erro ao atualizar produto');
            return res.json();
          })
          .then(() => {
            form.reset();
            btnAdd.textContent = "Adicionar Produto";
            carregarProdutos();
          })
          .catch(err => console.error('Erro:', err));
      } else {
        // Adicionar (POST)
        fetch(API_URL, {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(produto)
        })
          .then(res => {
            if (!res.ok) throw new Error('Erro ao adicionar produto');
            return res.json();
          })
          .then(() => {
            form.reset();
            carregarProdutos();
          })
          .catch(err => console.error('Erro:', err));
      }
    });

    // 🟦 Preencher o formulário ao clicar em "Editar"
    function editarProduto(id, nome, preco) {
      document.getElementById('produtoId').value = id;
      document.getElementById('nome').value = nome;
      document.getElementById('preco').value = preco;
      btnAdd.textContent = "Salvar Alterações";
    }

    // 🟥 Deletar produto
    function deletarProduto(id) {
      if (confirm('Tem certeza que deseja excluir este produto?')) {
        fetch(`${API_URL}/${id}`, { method: 'DELETE' })
          .then(res => {
            if (!res.ok) throw new Error('Erro ao excluir produto');
            carregarProdutos();
          })
          .catch(err => console.error('Erro:', err));
      }
    }

    // Carrega a lista ao abrir a página
    carregarProdutos();
  </script>

</body>
</html>
*/