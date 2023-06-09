create database veterinaria;
use veterinaria;

create table veterinario
(
id_v int not null auto_increment,
nombre_vet varchar(30),
telefono varchar(30),
primary key(id_v)
);
insert into veterinario(nombre_vet,telefono) values("Yulissa Pérez",'9995678909');
insert into veterinario(nombre_vet,telefono) values("Wiliam López",'9933456790');
insert into veterinario(nombre_vet,telefono) values("Jorge López",'9993454790');
insert into veterinario(nombre_vet,telefono) values("Rousaura Tamara",'9994456790');
insert into veterinario(nombre_vet,telefono) values("Carolina Briceño",'9995456790');
insert into veterinario(nombre_vet,telefono) values("Carlos Palomo",'9992456790');
insert into veterinario(nombre_vet,telefono) values("Pablo Eúan",'9990456790');
insert into veterinario(nombre_vet,telefono) values("Alondra Martínez",'9992456790');
insert into veterinario(nombre_vet,telefono) values("Laura Alvarez",'9993456790');

create table tipo
(
id_tipo int not null auto_increment,
nombre_tipo varchar(30),
primary key(id_tipo)
);
insert into tipo(nombre_tipo) values("Antiparasitarios");
insert into tipo(nombre_tipo) values("Inyectables");
insert into tipo(nombre_tipo) values("Orales");
insert into tipo(nombre_tipo) values("Tópicos intraoculares");
insert into tipo(nombre_tipo) values("Antibióticos");

create table medicinas
(
id_medicina int not null auto_increment,
nombre_tipo varchar(30) not null,
precio double not null,
nombre_medicina varchar(30) not null,

primary key(id_medicina)
);
insert into medicinas (nombre_medicina,nombre_tipo,precio) values("Isoflurano 200g",'Antiparasitarios',120);
insert into medicinas (nombre_medicina,nombre_tipo,precio) values("Desecante Gel 10g",'Inyectables',500);
insert into medicinas (nombre_medicina,nombre_tipo,precio) values("Adarfac 50g",'Orales',300);
insert into medicinas (nombre_medicina,nombre_tipo,precio) values("Ruinald Omega 60g",'Tópicos intraoculares',100);
insert into medicinas (nombre_medicina,nombre_tipo,precio) values("Gotas 150g",'Antibioticos',900);

create table mascotas(
id int not null auto_increment,
nombre varchar(30),
nombre_vet varchar(30) not null,
nombre_dueño varchar(30) not null,
medicina_1  varchar(30) not null,
medicina_2  varchar(30),
medicina_3  varchar(30),


primary key(id)
);
insert into mascotas(nombre,medicina_1,nombre_vet,nombre_dueño)values('Pupi','Gotas 150g','Yulissa Pérez','Maria Rodriguez');
insert into mascotas(nombre,medicina_1,nombre_vet,nombre_dueño)values('Perla','Ruinald Omega 60g','Wiliam López','Laura Salcido');
insert into mascotas(nombre,medicina_1,nombre_vet,nombre_dueño)values('Baxter','Isoflurano 200g','Jorge López','Maribel Guardia');
insert into mascotas(nombre,medicina_1,nombre_vet,nombre_dueño)values('Garfield','Desecante Gel 10g','Rousaura Tamara','Rubi Angelina');
insert into mascotas(nombre,medicina_1,nombre_vet,nombre_dueño)values('Pelos','Adarfac 50g','Carolina Briceño','Daniela Hernandez');
insert into mascotas(nombre,medicina_1,nombre_vet,nombre_dueño)values('Conchito','Gotas 150g','Carlos Palomo','Mario Bros');

create table dueño (
  id_dueño int not null auto_increment,
  nombre_dueño varchar(30),
  telefono varchar(10),
  direccion varchar(50),
  primary key (id_dueño)
);

insert into dueño (nombre_dueño, telefono, direccion) values ('María Rodriguez', '0991238976', 'Calle 23 x 45 s/n');
insert into dueño (nombre_dueño, telefono, direccion) values ('Laura Salcido', '9491238976', 'colonia padre 34 c');
insert into dueño (nombre_dueño, telefono, direccion) values ('Maribel Guardia', '1991238976', 'calle 34 x 45');
insert into dueño (nombre_dueño, telefono, direccion) values ('Rubí Angelina', '9911238976', '34 x 5 ni 1');
insert into dueño (nombre_dueño, telefono, direccion) values ('Daniela Hernandez', '9391238976', 'Calle 34 x 56 colonia');
insert into dueño (nombre_dueño, telefono, direccion) values ('Mario Bros', '9992238976', 'Calle 11 x 18 s/n');

CREATE TABLE consultas (
  id_consulta INT NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  mascota VARCHAR(30) NOT NULL,
  veterinario VARCHAR(30) NOT NULL,
  medicina_1  varchar(30) not null,
  medicina_2  varchar(30),
  medicina_3  varchar(30),
  PRIMARY KEY (id_consulta)
);


INSERT INTO consultas (fecha, hora, mascota, veterinario,medicina_1)
VALUES ('2023-06-05', '10:00:00', 'Pupi', 'Yulissa Pérez','inyeccion letal');

INSERT INTO consultas (fecha, hora, mascota, veterinario,medicina_1)
VALUES ('2023-06-06', '15:30:00', 'Perla', 'Wiliam López','inyeccion letal');
