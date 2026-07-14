# DuplaTrabalho - Controle de Estoque

Sistema de console desenvolvido em Java para organizar produtos, categorias e fornecedores de pequenos comércios. O projeto integra as disciplinas de Projeto de Desenvolvimento de Software (PDS) e Programação com Acesso a Banco de Dados (PABD).

## Equipe Duplati

- Luiz Mendes
- Luiz Gustavo

## Problema e objetivo

Pequenos comércios frequentemente controlam produtos e fornecedores por anotações separadas, o que dificulta a consulta, atualização e reposição dos itens. O DuplaTrabalho centraliza essas informações em um sistema de console com persistência em banco de dados relacional.

## Funcionalidades

- Cadastro, consulta, atualização e exclusão de categorias.
- Cadastro, consulta, atualização e exclusão de fornecedores.
- Cadastro, consulta, atualização e exclusão de produtos.
- Associação de cada produto a uma categoria e a um fornecedor.
- Persistência dos dados no MySQL por JDBC.

## Tecnologias

- Java 25 e orientação a objetos.
- JDBC e MySQL 8.
- Eclipse IDE.
- Git, GitHub, Scrum e Kanban.

## Estrutura do projeto

```text
src/       Código-fonte Java
sql/       Script de criação do banco
docs/      Documentação, planejamento e diagramas
lib/       Driver MySQL Connector/J
```

## Como executar

### Execução automática

1. Mantenha o MySQL Server iniciado.
2. Execute `iniciar-projeto.bat`.
3. Informe a senha do usuário `root` quando solicitada.

O iniciador prepara o banco, compila o projeto e abre o menu principal.

### Execução pelo Eclipse

1. Execute `sql/schema.sql` no MySQL Workbench.
2. Importe este repositório como projeto existente no Eclipse.
3. Confirme que `lib/mysql-connector-j-9.6.0.jar` está nas bibliotecas.
4. Execute `br.com.duplatrabalho.Main` como aplicação Java.

## Documentação

- [Instruções de execução](docs/instrucoes-execucao.md)
- [Planejamento ágil](docs/planejamento-agil.md)
- [Quadro Kanban](docs/quadro-kanban.md)
- [Banco de dados](docs/banco-de-dados.md)
- [Diagrama de classes](docs/diagrama-classes.puml)
- [Diagrama entidade-relacionamento](docs/der.md)
- [Interface do sistema](docs/interface-sistema.md)
