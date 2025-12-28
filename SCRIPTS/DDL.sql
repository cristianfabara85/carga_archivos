-- DDL PARA PANTALLA DE CARGA DE CAMPAÑAS
-- CHRISTIAN FABARA

---drop database carga_archivos;

create database carga_archivos WITH ENCODING = 'UTF8';


create table campania (
id SERIAL primary key,
codigo_campania int8 not null,
acronimo varchar(5),
ruc varchar(13) not null,
nombre_empresa varchar(100),
descripcion varchar(200),
fecha date,
numero_clientes int,
presupuesto float8
);


