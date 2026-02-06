create table empresa (
    id bigint not null primary key auto_increment,
    nome varchar(100) not null,
    razao_social varchar(100) not null,
    cnpj varchar(14) not null,
    ramo varchar(50) not null,
    endereco_id bigint not null,
    foreign key (endereco_id) references endereco(id)
)