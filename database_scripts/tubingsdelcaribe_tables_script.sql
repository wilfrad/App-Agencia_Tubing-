create database if not exists tubingsdelcaribe_db;

use tubingsdelcaribe_db;

create table if not exists super_administrador ( id_sadm int primary key not null auto_increment,
	usuario_sadm varchar(50) not null,
    pase_sadm varchar(50) not null
);

create table if not exists empleado ( id_emp int primary key not null auto_increment,
	nombres_emp  varchar(100) not null,
    apellidos_emp  varchar(100) not null,
    documento_emp  varchar(20) not null,
    telefono_emp  varchar(20) not null,
    direccion_emp  varchar(200) not null
);

create table if not exists administrador ( id_adm int primary key not null auto_increment,
	usuario_adm varchar(50) not null,
    pase_adm varchar(50) not null,
    fk_empleado_adm int not null,
    constraint fk_empleado_1 foreign key (fk_empleado_adm)
		references empleado(id_emp)
);

create table if not exists instrumento ( id_ins int primary key not null auto_increment,
	nombre_ins  varchar(50) not null,
    descripcion_ins  varchar(200),
	cantidad_ins  int not null
);

create table if not exists ruta ( id_rt int primary key not null auto_increment,
	nombre_rt varchar(100)
);

create table if not exists plan ( id_pn int primary key not null auto_increment,
	nombre_pn varchar(100) not null,
    lista_instrumentos_pn varchar(200) not null,
    valor_adulto_pn double,
    valor_infante_pn double,
    fk_ruta_pn int not null,
    constraint fk_ruta_1 foreign key (fk_ruta_pn) 
		references ruta(id_rt)
);

create table if not exists cliente ( id_clt int primary key not null auto_increment,
	nombres_clt  varchar(100) not null,
    apellidos_clt  varchar(100) not null,
    documento_clt  varchar(20) not null,
    telefono_clt  varchar(20) not null,
    direccion_clt  varchar(200)
);

create table if not exists servicio ( id_svc int primary key not null auto_increment,
	fk_cliente_svc int not null,
	fk_plan_svc int not null,
	constraint fk_cliente_1 foreign key (fk_cliente_svc)
		references cliente(id_clt),
    constraint fk_plan_1 foreign key (fk_plan_svc) 
		references plan(id_pn)
);

create table if not exists compañia ( id_cmp int primary key not null auto_increment,
	documento_cmp  varchar(20) not null,
    infante_cmp bit(1),
    fk_servicio_cmp  int not null,
    constraint fk_servicio_1 foreign key (fk_servicio_cmp) 
		references servicio(id_svc)
);

create table if not exists inventario ( id_inv int primary key not null auto_increment,
	cantidad_inv int not null,
    fk_servicio_inv int not null,
    fk_instrumento_inv int not null,
    constraint fk_servicio_2 foreign key (fk_servicio_inv) 
		references servicio(id_svc),
    constraint fk_instrumento_1 foreign key (fk_instrumento_inv) 
		references instrumento(id_ins)
);

create table if not exists factura ( id_fac int unsigned auto_increment primary key,
	total_cuenta_fac  double not null,
	fecha_emision_fac  date,
	fk_servicio_fac  int not null,
    fk_empleado_fac  int not null,
	constraint fk_servicio_3 foreign key (fk_servicio_fac) 
		references servicio(id_svc),
	constraint fk_empleado_2 foreign key (fk_empleado_fac)
		references empleado(id_emp)
);

create table if not exists unusable (id int primary key);

insert into unusable values(64);