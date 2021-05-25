create table products.product (
    id bigserial primary key,
    identificador varchar not null,
    nome varchar(100) not null,
    descricao varchar not null,
    preco float not null,
    category_id bigint REFERENCES products.category(id)
)