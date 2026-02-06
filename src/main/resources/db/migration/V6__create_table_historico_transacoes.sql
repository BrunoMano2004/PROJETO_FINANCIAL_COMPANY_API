create table transacao (
    id bigint not null primary key auto_increment,
    id_conta_cliente bigint not null,
    tipo_transacao varchar(8) not null,
    valor_bruto float not null,
    taxa_cobrada float not null,
    valor_liquido float not null
)