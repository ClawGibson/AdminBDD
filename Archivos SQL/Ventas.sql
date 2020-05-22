CREATE VIEW VerTodosArticulos
AS
	SELECT 
		nombre
	FROM
		Articulo;

SELECT * FROM VerTodosArticulos;
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC VentaArticulos(
	@Busqueda varchar(40)
)AS
BEGIN
	SELECT 
		nombre
	FROM
		Articulo
	WHERE
		nombre LIKE '%'+@Busqueda+'%';
END

EXEC VentaArticulos 'Leche';
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC NuevaVenta( -- Inicia una venta.
	@Fecha date
)AS
BEGIN
	INSERT INTO Ventas (fecha) VALUES (@Fecha);
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC NuevaVenta2( -- Carrito de venta.
	@Articulo varchar(40),
	@Cantidad float
)AS
BEGIN
	INSERT INTO VentasArticulo 
	VALUES ((SELECT TOP 1 idVenta FROM Ventas ORDER BY idVenta DESC), 
			(SELECT idArticulo FROM Articulo WHERE nombre = @Articulo),
			@Cantidad);
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC NuevaVenta3( -- Finalización de la venta.
	@Total float
)AS
BEGIN
	UPDATE Ventas
	SET
		total = @Total
	WHERE
		idVenta = (SELECT TOP 1 idVenta FROM Ventas ORDER BY idVenta DESC);
END

EXEC NuevaVenta2 'Galletas', 5
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC VerVenta(
	@Fecha date
)AS
BEGIN
	SELECT
	Ventas.idVenta,
		VentasArticulo.idArticulo,
		Articulo.nombre,
		cantidad,
		precio
	FROM
		Ventas INNER JOIN VentasArticulo ON Ventas.idVenta = VentasArticulo.idVenta
		INNER JOIN Articulo ON VentasArticulo.idArticulo = Articulo.idArticulo
	WHERE
		fecha = @Fecha
	ORDER BY Ventas.idVenta DESC
END

EXEC VerVenta '17 mayo 2020'
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC EliminarArticuloDeVenta(
	@id int,
	@Articulo varchar(40)
)AS
BEGIN
	DELETE FROM VentasArticulo
	WHERE
		idArticulo = (SELECT idArticulo FROM Articulo WHERE nombre = @Articulo) AND
		idVenta = @id;
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE VIEW ObtenerIdVenta
AS
	SELECT TOP 1 idVenta FROM Ventas ORDER BY idVenta DESC;

select * from ObtenerIdVenta;
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC VerCarritoVenta(
	@Id int
)AS
BEGIN
	SELECT
		Ventas.idVenta,
		VentasArticulo.idArticulo,
		Articulo.nombre,
		cantidad,
		precio
	FROM
		Ventas INNER JOIN VentasArticulo ON Ventas.idVenta = VentasArticulo.idVenta
		INNER JOIN Articulo ON VentasArticulo.idArticulo = Articulo.idArticulo
	WHERE
		Ventas.idVenta = @Id;
END

EXEC VerCarritoVenta 8
--------------------------------------------------------------------------------------------------------------------------------

SELECT * FROM ObtenerIdVenta
