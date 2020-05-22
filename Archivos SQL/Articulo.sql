SELECT * FROM Articulo

ALTER VIEW VerArticulos
AS
	SELECT
		idArticulo as Id,
		Articulo.nombre as Articulo,
		precio as Precio,
		Proveedores.nombre as Proveedor
	FROM
		Articulo INNER JOIN Proveedores
	ON
		Articulo.idProveedor = Proveedores.idProveedor;

SELECT * FROM VerArticulos
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC NuevoArticulo(
	@Nombre varchar(40),
	@Precio float,
	@Proveedor varchar(40)
)AS
BEGIN
	INSERT INTO Articulo (idProveedor, nombre, precio)
	VALUES ((SELECT idProveedor FROM Proveedores WHERE nombre = @Proveedor), @Nombre, @Precio);
END

EXEC NuevoArticulo 'Leche', 12.57, 'Juan'
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC BuscarArticulo(
	@Nombre varchar(40)
)AS
BEGIN
	SELECT
		nombre
	FROM
		Articulo
	WHERE
		nombre = @Nombre;	
END

EXEC BuscarArticulo 'Leche'
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC ModificarArticulo(
	@Id int,
	@Nombre varchar(40),
	@Precio float,
	@Proveedor varchar(40)
)AS
BEGIN
	UPDATE Articulo
	SET
		nombre = @Nombre,
		precio = @Precio,
		idProveedor = (SELECT idProveedor FROM Proveedores WHERE nombre = @Proveedor)
	WHERE
		idArticulo = @Id
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC EliminarArticulo(
	@Nombre varchar(40)
)AS
BEGIN
	DELETE FROM Articulo
	WHERE
		idArticulo = (SELECT idArticulo FROM Articulo WHERE nombre = @Nombre)
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC BuscarArticulos(
	@Nombre varchar(40)
)
AS
BEGIN
	SELECT
		idArticulo as Id,
		Articulo.nombre as Articulo,
		precio as Precio,
		Proveedores.nombre as Proveedor
	FROM
		Articulo INNER JOIN Proveedores
	ON
		Articulo.nombre LIKE '%'+@Nombre+'%' AND
		Proveedores.idProveedor = Articulo.idProveedor;
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC ConsultarArticulo(
	@Nombre varchar(40)
)
AS
BEGIN
	SELECT
		idArticulo as Id,
		Articulo.nombre as Articulo,
		precio as Precio,
		Proveedores.nombre as Proveedor
	FROM
		Articulo INNER JOIN Proveedores
	ON
		Articulo.nombre = @Nombre AND
		Proveedores.idProveedor = Articulo.idProveedor;
END
--------------------------------------------------------------------------------------------------------------------------------