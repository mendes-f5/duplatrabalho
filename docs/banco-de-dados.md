# Banco de dados

O banco `duplatrabalho` possui três entidades:

| Entidade | Finalidade |
| --- | --- |
| Categoria | Classifica os produtos cadastrados. |
| Fornecedor | Mantém os dados de contato de quem fornece os produtos. |
| Produto | Registra nome, quantidade, preço, categoria e fornecedor. |

Cada produto referencia uma categoria e um fornecedor, formando dois relacionamentos de um para muitos.

O script completo está em [sql/schema.sql](../sql/schema.sql).
