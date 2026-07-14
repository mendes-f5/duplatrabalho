package br.com.duplatrabalho.dao;

import br.com.duplatrabalho.config.Conexao;
import br.com.duplatrabalho.modelo.Fornecedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
    public void inserir(Fornecedor fornecedor) throws SQLException {
        try (Connection c = Conexao.obter(); PreparedStatement p = c.prepareStatement("INSERT INTO fornecedor (nome, telefone, email) VALUES (?, ?, ?)")) {
            p.setString(1, fornecedor.getNome()); p.setString(2, fornecedor.getTelefone()); p.setString(3, fornecedor.getEmail()); p.executeUpdate();
        }
    }
    public List<Fornecedor> listar() throws SQLException {
        List<Fornecedor> itens = new ArrayList<>();
        try (Connection c = Conexao.obter(); Statement s = c.createStatement(); ResultSet r = s.executeQuery("SELECT * FROM fornecedor ORDER BY nome")) {
            while (r.next()) itens.add(new Fornecedor(r.getInt("id"), r.getString("nome"), r.getString("telefone"), r.getString("email")));
        }
        return itens;
    }
    public void atualizar(Fornecedor fornecedor) throws SQLException {
        try (Connection c = Conexao.obter(); PreparedStatement p = c.prepareStatement("UPDATE fornecedor SET nome=?, telefone=?, email=? WHERE id=?")) {
            p.setString(1, fornecedor.getNome()); p.setString(2, fornecedor.getTelefone()); p.setString(3, fornecedor.getEmail()); p.setInt(4, fornecedor.getId()); p.executeUpdate();
        }
    }
    public void excluir(int id) throws SQLException {
        try (Connection c = Conexao.obter(); PreparedStatement p = c.prepareStatement("DELETE FROM fornecedor WHERE id=?")) {
            p.setInt(1, id); p.executeUpdate();
        }
    }
}

