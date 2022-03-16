create table if not exists fornecedor (
	id bigint not null auto_increment primary key,
	nome varchar(255) not null,
	ativo bool not null
);

insert into fornecedor (nome, ativo)
values
('fornecedor 1', true);