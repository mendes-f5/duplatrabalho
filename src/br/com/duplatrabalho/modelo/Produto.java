package br.com.duplatrabalho.modelo;

import java.math.BigDecimal;

public class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private BigDecimal preco;
    private int categoriaId;
    private int fornecedorId;

    public Produto() { }

    public Produto(int id, String nome, int quantidade, BigDecimal preco, int categoriaId, int fornecedorId) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.categoriaId = categoriaId;
        this.fornecedorId = fornecedorId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }
    public int getFornecedorId() { return fornecedorId; }
    public void setFornecedorId(int fornecedorId) { this.fornecedorId = fornecedorId; }

    @Override
    public String toString() {
        return "%d - %s | qtd: %d | R$ %s | categoria: %d | fornecedor: %d"
                .formatted(id, nome, quantidade, preco, categoriaId, fornecedorId);
    }
}

