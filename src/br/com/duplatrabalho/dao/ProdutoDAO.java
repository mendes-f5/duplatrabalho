package br.com.duplatrabalho.dao;

import br.com.duplatrabalho.config.Conexao;
import br.com.duplatrabalho.modelo.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome, quantidade, preco, categoria_id, fornecedor_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection c = Conexao.obter(); PreparedStatement p = c.prepareStatement(sql)) { preencher(p, produto); p.executeUpdate(); }
    }
    public List<Produto> listar() throws SQLException {
        List<Produto> itens = new ArrayList<>();
        try (Connection c = Conexao.obter(); Statement s = c.createStatement(); ResultSet r = s.executeQuery("SELECT * FROM produto ORDER BY nome")) {
            while (r.next()) itens.add(new Produto(r.getInt("id"), r.getString("nome"), r.getInt("quantidade"), r.getBigDecimal("preco"), r.getInt("categoria_id"), r.getInt("fornecedor_id")));
        }
        return itens;
    }
    public void atualizar(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET nome=?, quantidade=?, preco=?, categoria_id=?, fornecedor_id=? WHERE id=?";
        try (Connection c = Conexao.obter(); PreparedStatement p = c.prepareStatement(sql)) { preencher(p, produto); p.setInt(6, produto.getId()); p.executeUpdate(); }
    }
    public void excluir(int id) throws SQLException {
        try (Connection c = Conexao.obter(); PreparedStatement p = c.prepareStatement("DELETE FROM produto WHERE id=?")) { p.setInt(1, id); p.executeUpdate(); }
    }
    private void preencher(PreparedStatement p, Produto produto) throws SQLException {
        p.setString(1, produto.getNome()); p.setInt(2, produto.getQuantidade()); p.setBigDecimal(3, produto.getPreco()); p.setInt(4, produto.getCategoriaId()); p.setInt(5, produto.getFornecedorId());
    }
}

