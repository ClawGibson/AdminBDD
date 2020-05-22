SELECT * FROM Clientes;

CREATE VIEW VerClientes
AS
	SELECT
		idCliente as Id,
		Clientes.nombre as Nombre,
		direccion as Dir,
		telefono as Tel,
		Ciudades.Nombre as Cd,
		email as Email,
		rfc as RFC
	FROM
		Clientes INNER JOIN Ciudades
	ON
		Clientes.idCiudad = Ciudades.idCiudad;

SELECT * FROM VerClientes;
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC NuevoCliente(
	@Nombre varchar(40),
	@Direccion varchar(40),
	@Telefono int,
	@Ciudad varchar(40),
	@Email varchar(40),
	@RFC varchar(40)
)AS
BEGIN
	INSERT INTO Clientes (nombre, direccion, telefono, idCiudad, email, rfc)
	VALUES (@Nombre, @Direccion, @Telefono, (SELECT idCiudad FROM Ciudades WHERE Nombre = @Ciudad), @Email, @RFC);
END

EXEC NuevoCliente 'Cliente 1', 'dirCliente1', 123460, 'Ciudad Guzmán', 'cliente1@gmail.com', 'RFCCliente1';
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC ModificarCliente(
	@id int,
	@Nombre varchar(40),
	@Direccion varchar(40),
	@Telefono int,
	@Ciudad varchar(40),
	@Email varchar(40),
	@RFC varchar(40)
)AS
BEGIN
	UPDATE Clientes
	SET
		nombre = @Nombre,
		direccion = @Direccion,
		telefono = @Telefono,
		idCiudad = (SELECT idCiudad FROM Ciudades WHERE nombre = @Ciudad),
		email = @Email,
		rfc = @RFC
	WHERE
		idCliente = @id;
END

EXEC ModificarCliente 1, 'Nuevoc', 'nuevaDir', 00001, 'Zapotlán', 'nuevoE@gmail.com', 'RFCNuevo';
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC EliminarCliente(
	@Nombre varchar(40)
)AS
BEGIN
	DELETE FROM Clientes
	WHERE idCliente = (SELECT idCliente FROM Clientes WHERE nombre = @Nombre);
END


--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC BuscarClientes(
	@Nombre varchar(40)
)AS
BEGIN
	SELECT
		idCliente as Id,
		Clientes.nombre as Nombre,
		direccion as Dir,
		telefono as Tel,
		Ciudades.Nombre as Cd,
		email as Email,
		rfc as RFC
	FROM
		Clientes INNER JOIN Ciudades
	ON
		Clientes.nombre LIKE '%'+@Nombre+'%' AND Clientes.idCiudad = Ciudades.idCiudad;
END

EXEC BuscarClientes 'c'
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC BuscarCliente(
	@Nombre varchar(40)
)AS
BEGIN
	SELECT
		nombre
	FROM
		Clientes
	WHERE
		idCliente = (SELECT idCliente FROM Clientes WHERE nombre = @Nombre);
END

EXEC BuscarCliente 'Nuevoc'
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
