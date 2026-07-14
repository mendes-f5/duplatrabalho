# Instruções de execução

## Requisitos

- Java 25 ou superior.
- MySQL Server 8 em execução.
- Usuário `root` configurado no MySQL.

## Pelo iniciador

Execute `iniciar-projeto.bat`. O arquivo solicita a senha do MySQL, cria o banco, compila as classes e abre o sistema.

## Pelo Eclipse

1. Importe o projeto como projeto Java existente.
2. Adicione `lib/mysql-connector-j-9.6.0.jar` ao Build Path, caso o Eclipse não o reconheça automaticamente.
3. Execute `sql/schema.sql` no MySQL Workbench.
4. Configure a variável de ambiente `DUPLATRABALHO_DB_SENHA` com a senha local do MySQL, se desejar substituir o valor padrão.
5. Execute a classe `br.com.duplatrabalho.Main`.
