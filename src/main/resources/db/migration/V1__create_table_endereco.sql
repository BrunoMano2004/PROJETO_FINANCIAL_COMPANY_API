create table endereco (
    id bigint primary key not null auto_increment,
    logradouro varchar(120) not null,
    numero int not null,
    bairro varchar(50) not null,
    cidade varchar(50) not null,
    uf varchar(2) not null,
    cep varchar(8) not null,
    complemento varchar(50)
)