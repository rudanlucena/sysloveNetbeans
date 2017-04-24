create table usuarios(
	email varchar(150) primary key,
	senha varchar(25) not null,
	nome varchar(150) not null,
	apelido varchar(25) not null,
	dataNascimento varchar(10) not null,
	cidade varchar(150) not null,
	profissao varchar(150) not null,
	descricao text,
	passatempo text,  
	status varchar(25) not null,
	peso float,
	altura float,
	corCabelo varchar(25),
	fotoPerfil varchar(25),
	sexo varchar(25)
);


create table galeriaFotos(
	usuario varchar(150) not null,
	imagem varchar(25) not null,
	legenda varchar(150),
	primary key(usuario, imagem),
	foreign key(usuario) references usuarios(email) ON DELETE CASCADE ON UPDATE CASCADE
);


create table solicitacoesAmizade(
	remetente varchar(150) not null,
	destinatario varchar(150) not null,
	primary key(remetente, destinatario),
	foreign key(remetente) references usuarios(email) ON DELETE CASCADE ON UPDATE CASCADE,
	foreign key(destinatario) references usuarios(email) ON DELETE CASCADE ON UPDATE CASCADE
);

create table recomendacoesAmizade(
	remetente varchar(150) not null,
	destinatario varchar(150) not null,
	recomendacao varchar(150) not null,
	primary key(remetente, destinatario, recomendacao),
	foreign key(remetente) references usuarios(email) ON DELETE CASCADE ON UPDATE CASCADE,
	foreign key(destinatario) references usuarios(email) ON DELETE CASCADE ON UPDATE CASCADE,
	foreign key(recomendacao) references usuarios(email) ON DELETE CASCADE ON UPDATE CASCADE
);


create table relacionamentos(
	usuario1 varchar(150),
	usuario2 varchar(150),
	tipoRelacionamento varchar(25) not null,
	primary key(usuario1, usuario2),
	foreign key(usuario1) references usuarios(email) ON DELETE CASCADE ON UPDATE CASCADE,
	foreign key(usuario2) references usuarios(email) ON DELETE CASCADE ON UPDATE CASCADE
);


create table mensagens(
	remetente varchar(150) not null,
	destinatario varchar(150) not null,
	mensagem varchar(1000) not null,
	foreign key(remetente) references usuarios(email) ON DELETE CASCADE ON UPDATE CASCADE,
	foreign key(destinatario) references usuarios(email) ON DELETE CASCADE ON UPDATE CASCADE
);


create table TimeLine(
	usuario varchar(150) not null,
	imagem varchar(25),
	legenda varchar(150),
	primary key(usuario, imagem),
	foreign key(usuario) references usuarios(email) ON DELETE CASCADE ON UPDATE CASCADE
);