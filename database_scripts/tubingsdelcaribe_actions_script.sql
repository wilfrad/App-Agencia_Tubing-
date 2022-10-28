use tubingsdelcaribe_db;

delimiter //

create procedure get_public_tables ()
begin
	declare lista_tabla_nonbres varchar(200);
    set lista_tabla_nonbres = 'compañia,cliente,inventario,instrumento,plan,ruta,servicio,factura';
    select lista_tabla_nonbres;
end;

//

delimiter //

create procedure get_todo_tables ()
begin
	declare lista_tabla_nonbres varchar(400);
    select group_concat(table_name) 'tablas' from information_schema.tables
    where table_schema = 'tubingsdelcaribe_db'
		into lista_tabla_nonbres;
    select lista_tabla_nonbres;
end;

//

delimiter //

create procedure get_table_columns (nombre_tabla varchar(50))
begin
	select group_concat(column_name) 'tabla columnas' from information_schema.columns
    where table_name = nombre_tabla;
end;


//

delimiter //

create procedure admin_login (user_pmt varchar(50), pass_pmt varchar(50))
begin
	declare result varchar(250);
    declare name_result varchar(200);
    select if(usuario_adm = user_pmt and pase_adm = pass_pmt, true, false) from administrador
		into result;
	if (result = true) then
		select concat(nombres_emp, ' ', apellidos_emp) from administrador
        inner join empleado on id_emp = fk_empleado_adm
			into name_result;
		set result = concat(result, ',', name_result);
    end if;
	select result;
end;

//

delimiter //

create trigger inventory_monitor 
before insert on inventario
for each row
begin
	declare diff int;
	declare available_instrument int;
    select cantidad_ins from instrumento where id_ins = new.fk_instrumento_inv
     into available_instrument;
    set diff = available_instrument - new.cantidad_inv;
    if(diff < 0) then
		update instrumento set cantidad_ins = 0
			where id_ins = new.fk_instrumento_inv;
		set new.cantidad_inv = new.cantidad_inv - abs(diff);
	else
		update instrumento set cantidad_ins = diff
			where id_ins = new.fk_instrumento_inv;
    end if;
end;

//