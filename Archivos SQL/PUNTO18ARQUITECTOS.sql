CREATE DATABASE PUNTO18ARQUITECTOS

USE PUNTO18ARQUITECTOS

create table Ciudades
(
	idCiudad int identity(1,1),
	Nombre varchar(40) not null,
	primary key(idCiudad)
)

create table Tecnicos
(
	idTecnico int identity(1,1),
	Nombre varchar(40)not null,	
	telefono varchar(20),
	idCiudad int ,
	primary key(idTecnico),
	foreign key (idCiudad) references Ciudades(idCiudad),
)

create table Maquinaria
(	
	idMaquinaria int identity(1,1),
	Nombre varchar(40),
	primary key(idMaquinaria)
)

create table Mantenimiento
(	
	idMaquinaria int not null,
	idTecnico int not null,
	Fecha date not null,
	primary key(idMaquinaria),
	foreign key(idTecnico) references Tecnicos(idTecnico)
)

create table Proveedores(
	idProveedor int primary key identity (1,1),
	nombre varchar (40) not null,
	direccion varchar (50) not null,
	telefono varchar (10) not null,
	idCiudad int not null,
	cp int not null,
	foreign key (idCiudad) references Ciudades(idCiudad),
)

create table Clientes(
	idCliente int primary key identity (1,1),
	nombre varchar (40) not null,
	direccion varchar (50) not null,
	telefono varchar (10) not null,
	idCiudad int not null,
	email varchar(30)not null,
	rfc varchar(20) not null,
	foreign key (idCiudad) references Ciudades(idCiudad),
)

create table Usuarios
(
	idUsuario int identity(1,1),
	Nombre varchar(40)not null,	
	direccion varchar(20),
	telefono int,
	idCiudad int ,
	primary key(idUsuario),
	foreign key (idCiudad) references Ciudades(idCiudad),
)

create table Articulo
(
	idArticulo int identity(1,1),
	idProveedor int not null,
	nombre varchar(40) not null,
	precio float not null,
	primary key(idArticulo),
	foreign key (idProveedor) references Proveedores(idProveedor),
)

create table Compras
(
	idCompra int identity(1,1),
	total float,
	fecha date,
	primary key(idCompra)
)

create table ComprasArticulo
(
	idCompra int not null,	
	idArticulo int not null,
	cantidad int not null,
	foreign key (idCompra) references Compras(idCompra),
	foreign key (idArticulo) references Articulo(idArticulo)
)

create table Ventas
(
	idVenta int identity(1,1),
	total float,
	fecha date,
	primary key(idVenta)
)

create table VentasArticulo
(
	idVenta int not null,	
	idArticulo int not null,
	cantidad int not null,
	foreign key (idVenta) references Ventas(idVenta),
	foreign key (idArticulo) references Articulo(idArticulo)
)