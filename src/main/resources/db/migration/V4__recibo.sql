create table if not exists recibo (
	id bigint not null auto_increment primary key,
	fornecedor_id bigint not null,
	usuario_id varchar(255) not null,
	usuario_nome varchar(255) not null,
	data datetime not null,
	valor numeric not null,
	status varchar(255) not null,
	foreign key (fornecedor_id) references fornecedor(id)
);

insert into recibo (fornecedor_id, usuario_id, usuario_nome, data, valor, status)
values
(1, 1, 'ozaru', '20220316 00:00:01', 200.25, 'AGUARDANDO_ENVIO'),
(1, 1, 'ozaru', '20220316 00:00:01', 100.05, 'AGUARDANDO_ENVIO');