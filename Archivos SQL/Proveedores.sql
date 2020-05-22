SELECT * FROM Proveedores;

CREATE VIEW VerProveedores
AS
	SELECT
		idProveedor as Id,
		Proveedores.nombre as Nombre,
		direccion as Dir,
		telefono as Tel,
		Ciudades.Nombre as Cd
	FROM
		Proveedores INNER JOIN Ciudades
	ON
		Proveedores.idCiudad = Ciudades.idCiudad;

SELECT * FROM VerProveedores;
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC NuevoProveedor(
	@Nombre varchar(40),
	@Direccion varchar(40),
	@Telefono int,
	@Ciudad varchar(40)
)AS
BEGIN
	INSERT INTO Proveedores (nombre, direccion, telefono, idCiudad)
	VALUES (@Nombre, @Direccion, @Telefono, (SELECT idCiudad FROM Ciudades WHERE Nombre = @Ciudad))
END

EXEC NuevoProveedor 'Proveedor 1', 'direccion 1', 1324657, 'Guanajuato'
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC ModificarProveedor(
	@id int,
	@Nombre varchar(40),
	@Direccion varchar(40),
	@Telefono int,
	@Ciudad varchar(40)
)AS
BEGIN
	UPDATE Proveedores
	SET
		nombre = @Nombre,
		direccion = @Direccion,
		telefono = @Telefono,
		idCiudad = (SELECT idCiudad FROM Ciudades WHERE Nombre = @Ciudad)
	WHERE
		idProveedor = @id;
END

EXEC ModificarProveedor 1, 'Juan', 'dirJuan', 9841, 'Zapotlán'
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC EliminarProveedor(
	@Nombre varchar(40)
)AS
BEGIN
	DELETE FROM Proveedores
	WHERE idProveedor = (SELECT idProveedor FROM Proveedores WHERE nombre = @Nombre);
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC BuscarProveedores(
	@Nombre varchar(40)
)AS
BEGIN
	SELECT
		Proveedores.idProveedor as Id,
		Proveedores.nombre,
		direccion as Dir,
		telefono as Tel,
		Ciudades.Nombre as Cd
	FROM
		Proveedores INNER JOIN Ciudades
	ON
		Proveedores.nombre LIKE '%' +@Nombre +'%' AND Proveedores.idCiudad = Ciudades.idCiudad;
END

EXEC BuscarProveedores 'j';
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC BuscarProveedor(
	@Nombre varchar(40)
)AS
BEGIN
	SELECT
		nombre
	FROM
		Proveedores
	WHERE
		idProveedor = (SELECT idProveedor FROM Proveedores WHERE nombre = @Nombre);
END

EXEC BuscarProveedor 'Juan';
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------