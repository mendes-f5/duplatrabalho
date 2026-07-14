package br.com.duplatrabalho.dao;

import br.com.duplatrabalho.config.Conexao;
import br.com.duplatrabalho.modelo.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public void inserir(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (nome, descricao) VALUES (?, ?)";
        try (Connection c = Conexao.obter(); PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, categoria.getNome()); p.setString(2, categoria.getDescricao()); p.executeUpdate();
        }
    }
    public List<Categoria> listar() throws SQLException {
        List<Categoria> itens = new ArrayList<>();
        try (Connection c = Conexao.obter(); Statement s = c.createStatement(); ResultSet r = s.executeQuery("SELECT * FROM categoria ORDER BY nome")) {
            while (r.next()) itens.add(new Categoria(r.getInt("id"), r.getString("nome"), r.getString("descricao")));
        }
        return itens;
    }
    public void atualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE categoria SET nome=?, descricao=? WHERE id=?";
        try (Connection c = Conexao.obter(); PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, categoria.getNome()); p.setString(2, categoria.getDescricao()); p.setInt(3, categoria.getId()); p.executeUpdate();
        }
    }
    public void excluir(int id) throws SQLException {
        try (Connection c = Conexao.obter(); PreparedStatement p = c.prepareStatement("DELETE FROM categoria WHERE id=?")) {
            p.setInt(1, id); p.executeUpdate();
        }
    }
}

