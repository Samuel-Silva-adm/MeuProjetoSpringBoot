package com.produtoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Produto {

    @Id
    // ✅ AUTO é mais compatível com SQLite (gera id automaticamente)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Informe um nome.")
    private String nome;

    @PositiveOrZero(message = "A quantidade não pode ser negativa.")
    private int quantidade;

    @PositiveOrZero(message = "O preço não pode ser negativo.")
    private double preco;

    private Boolean disponivel;

    public Produto() {}

    public Produto(String nome, int quantidade, double preco, Boolean disponivel) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.disponivel = disponivel != null ? disponivel : false;
    }

    // ===== Getters e Setters =====
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }
    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel != null ? disponivel : false;
    }

    public boolean isDisponivel() {
        return Boolean.TRUE.equals(this.disponivel);
    }
}







