create table cliente (
    id bigint not null primary key auto_increment,
    nome_completo varchar(100) not null,
    cpf varchar(11) not null,
    genero varchar(10),
    data_nascimento varchar(10),
    endereco_id bigint,
    foreign key (endereco_id) references endereco(id)
)