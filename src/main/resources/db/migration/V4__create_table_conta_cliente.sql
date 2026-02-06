create table conta_cliente (
    id bigint not null primary key auto_increment,
    cliente_id bigint,
    empresa_id bigint,
    saldo float not null default 0.00
)