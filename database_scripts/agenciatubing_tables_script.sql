create database if not exists agenciatubing_db;

use agenciatubing_db;

create table if not exists cliente ( id int primary key not null auto_increment,
	nombres varchar(100) not null,
    apellidos varchar(100) not null,
    documento varchar(20) not null,
    telefono varchar(20) not null,
    direccion varchar(200)
);

create table if not exists acompañante ( id int primary key not null auto_increment,
	documento varchar(20) not null,
    id_grupo int not null,
	nombreCompleto varchar(150),
    constraint id_grupo_acompañante foreign key (id_grupo) 
		references cliente(id)
);

create table if not exists empleado ( id int primary key not null auto_increment,
	nombres varchar(100) not null,
    apellidos varchar(100) not null,
    documento varchar(20) not null,
    telefono varchar(20) not null,
    direccion varchar(200) not null
);

create table if not exists elemento ( id int primary key not null auto_increment,
	nombre varchar(50) not null,
    descripcion varchar(200),
	cantidad int not null,
    capacidad int not null
);

create table if not exists plan ( id int primary key not null auto_increment,
	nombre varchar(50) not null,
    descripcion varchar(200) not null
);

create table if not exists administrador ( id int primary key not null,
	usuario varchar(50) not null,
    contraseña varchar(50) not null,
    activo bit,
    id_empleado int not null,
    constraint id_empleado_administrador foreign key (id_empleado)
		references empleado(id)
);

create table if not exists servicio ( id int primary key not null auto_increment,
	id_cliente int not null,
	id_plan int not null,
	constraint id_cliente_servicio foreign key (id_cliente)
		references cliente(id),
    constraint id_plan_servicio foreign key (id_plan) 
		references plan(id)
);

create table if not exists inventario ( id int primary key not null auto_increment,
	ubicacion varchar(30) not null,
	id_elemento int not null,
    id_servicio int not null,
    constraint id_elemento_inventario foreign key (id_elemento) 
		references elemento(id),
    constraint id_servicio_inventario foreign key (id_servicio) 
		references servicio(id)
);

create table if not exists factura ( id int unsigned auto_increment primary key,
	total double not null,
	fecha_emision date,
    id_empleado int not null,
	id_cliente int not null,
	id_servicio int not null,
    constraint id_empleado_factura foreign key (id_empleado)
		references empleado(id),
	constraint id_cliente_factura foreign key (id_cliente) 
		references cliente(id),
	constraint id_servicio_factura foreign key (id_servicio) 
		references servicio(id)
);