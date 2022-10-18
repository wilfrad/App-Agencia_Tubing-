use agenciatubing_db;

delimiter //

create procedure get_tabla_columnas (nombre_tabla varchar(50))
begin
	select group_concat(column_name) 'tabla columnas' from information_schema.columns
    where table_name = nombre_tabla;
end;


//

delimiter //

create procedure administrador_activar_sesion ()
begin
	
end;

//
    
call get_tabla_columnas ('factura');