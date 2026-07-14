package br.com.duplatrabalho.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/duplatrabalho?useSSL=false&serverTimezone=America/Sao_Paulo";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";

    private Conexao() {
    }

    public static Connection obter() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}

