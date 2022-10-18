create database if not exists agenciatubing_reg;

use agenciatubing_reg;

create table sesion_registro ( id int primary key not null auto_increment,
	id_empleado int not null,
	fecha_entrada datetime not null,
    fecha_salida datetime
);

create table empleado_registro ( id int primary key not null auto_increment,
	accion varchar(50) not null,
    lugar_alterado varchar(100) not null,
    fecha_registro datetime not null
);

create table inventario_registro ( id int primary key not null auto_increment,
	elemento_salida int not null,
    id_empleado int not null,
    fecha_registro datetime not null
);

create table copia_factura ( id int,
	total double,
	fecha_emision date,
    id_empleado int,
	id_cliente int,
	id_servicio int,
    fecha_registro datetime not null
);