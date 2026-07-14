-- Script principal de criação do banco de dados DuplaTrabalho.
CREATE DATABASE IF NOT EXISTS duplatrabalho
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE duplatrabalho;

CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(80) NOT NULL UNIQUE,
    descricao VARCHAR(255)
);

CREATE TABLE fornecedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(120)
);

CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    quantidade INT NOT NULL DEFAULT 0,
    preco DECIMAL(10,2) NOT NULL,
    categoria_id INT NOT NULL,
    fornecedor_id INT NOT NULL,
    CONSTRAINT fk_produto_categoria FOREIGN KEY (categoria_id)
        REFERENCES categoria(id),
    CONSTRAINT fk_produto_fornecedor FOREIGN KEY (fornecedor_id)
        REFERENCES fornecedor(id)
);
