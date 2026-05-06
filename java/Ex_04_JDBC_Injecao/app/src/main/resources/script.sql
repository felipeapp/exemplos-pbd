drop database if exists agenda;
create database agenda;

use agenda;

create table contato (
    id int primary key auto_increment not null,
    nome varchar(250) not null,
    email varchar(250) unique not null,
    rg int unique not null,
    cadastro datetime not null default now()
);

insert into contato (nome, email, rg) values
    ("Felipe", "felipe@gmail.com", 1111),
    ("Maria", "maria@gmail.com", 2222),
    ("Ana", "ana@gmail.com", 3333),
    ("João", "joao@gmail.com", 4444);

select * from contato;
