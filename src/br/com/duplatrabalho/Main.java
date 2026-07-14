package br.com.duplatrabalho;

import br.com.duplatrabalho.dao.CategoriaDAO;
import br.com.duplatrabalho.dao.FornecedorDAO;
import br.com.duplatrabalho.dao.ProdutoDAO;
import br.com.duplatrabalho.modelo.Categoria;
import br.com.duplatrabalho.modelo.Fornecedor;
import br.com.duplatrabalho.modelo.Produto;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner ENTRADA = new Scanner(System.in);
    private static final CategoriaDAO CATEGORIAS = new CategoriaDAO();
    private static final FornecedorDAO FORNECEDORES = new FornecedorDAO();
    private static final ProdutoDAO PRODUTOS = new ProdutoDAO();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu(); opcao = inteiro("Opção: ");
            try {
                switch (opcao) {
                    case 1 -> cadastrarCategoria(); case 2 -> listarCategorias(); case 3 -> alterarCategoria(); case 4 -> excluirCategoria();
                    case 5 -> cadastrarFornecedor(); case 6 -> listarFornecedores(); case 7 -> alterarFornecedor(); case 8 -> excluirFornecedor();
                    case 9 -> cadastrarProduto(); case 10 -> listarProdutos(); case 11 -> alterarProduto(); case 12 -> excluirProduto();
                    case 0 -> System.out.println("Sistema encerrado.");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (SQLException e) { System.out.println("Erro no banco de dados: " + e.getMessage()); }
        } while (opcao != 0);
        ENTRADA.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== DUPLATRABALHO | CONTROLE DE ESTOQUE ===");
        System.out.println("1 Cadastrar categoria | 2 Listar categorias | 3 Alterar categoria | 4 Excluir categoria");
        System.out.println("5 Cadastrar fornecedor | 6 Listar fornecedores | 7 Alterar fornecedor | 8 Excluir fornecedor");
        System.out.println("9 Cadastrar produto | 10 Listar produtos | 11 Alterar produto | 12 Excluir produto");
        System.out.println("0 Sair");
    }

    private static void cadastrarCategoria() throws SQLException { CATEGORIAS.inserir(new Categoria(0, texto("Nome: "), texto("Descrição: "))); mensagem("Categoria cadastrada"); }
    private static void listarCategorias() throws SQLException { CATEGORIAS.listar().forEach(System.out::println); }
    private static void alterarCategoria() throws SQLException { CATEGORIAS.atualizar(new Categoria(inteiro("Id: "), texto("Nome: "), texto("Descrição: "))); mensagem("Categoria atualizada"); }
    private static void excluirCategoria() throws SQLException { CATEGORIAS.excluir(inteiro("Id: ")); mensagem("Categoria excluída"); }

    private static void cadastrarFornecedor() throws SQLException { FORNECEDORES.inserir(fornecedor(0)); mensagem("Fornecedor cadastrado"); }
    private static void listarFornecedores() throws SQLException { FORNECEDORES.listar().forEach(System.out::println); }
    private static void alterarFornecedor() throws SQLException { FORNECEDORES.atualizar(fornecedor(inteiro("Id: "))); mensagem("Fornecedor atualizado"); }
    private static void excluirFornecedor() throws SQLException { FORNECEDORES.excluir(inteiro("Id: ")); mensagem("Fornecedor excluído"); }
    private static Fornecedor fornecedor(int id) { return new Fornecedor(id, texto("Nome: "), texto("Telefone: "), texto("E-mail: ")); }

    private static void cadastrarProduto() throws SQLException { PRODUTOS.inserir(produto(0)); mensagem("Produto cadastrado"); }
    private static void listarProdutos() throws SQLException { PRODUTOS.listar().forEach(System.out::println); }
    private static void alterarProduto() throws SQLException { PRODUTOS.atualizar(produto(inteiro("Id: "))); mensagem("Produto atualizado"); }
    private static void excluirProduto() throws SQLException { PRODUTOS.excluir(inteiro("Id: ")); mensagem("Produto excluído"); }
    private static Produto produto(int id) { return new Produto(id, texto("Nome: "), inteiro("Quantidade: "), new BigDecimal(texto("Preço: ").replace(',', '.')), inteiro("Id da categoria: "), inteiro("Id do fornecedor: ")); }

    private static String texto(String rotulo) { System.out.print(rotulo); return ENTRADA.nextLine().trim(); }
    private static int inteiro(String rotulo) { return Integer.parseInt(texto(rotulo)); }
    private static void mensagem(String texto) { System.out.println(texto + " com sucesso."); }
}

