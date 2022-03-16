create table if not exists item (
	id bigint not null auto_increment primary key,
	nome varchar(255) not null,
	ativo bool not null
);