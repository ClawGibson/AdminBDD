CREATE VIEW InfoVentas AS
SELECT
		Ventas.idVenta,
		VentasArticulo.idArticulo,
		Articulo.nombre,
		cantidad,
		precio,
		total,
		Ventas.fecha
	FROM
		Ventas INNER JOIN VentasArticulo ON Ventas.idVenta = VentasArticulo.idVenta
		INNER JOIN Articulo ON VentasArticulo.idArticulo = Articulo.idArticulo
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC VerInfoVentas(
	@Busqueda varchar(40)
)AS
BEGIN
	SELECT
		Ventas.idVenta,
		VentasArticulo.idArticulo,
		Articulo.nombre,
		cantidad,
		precio,
		total,
		Ventas.fecha
	FROM
		Ventas INNER JOIN VentasArticulo ON Ventas.idVenta = VentasArticulo.idVenta
		INNER JOIN Articulo ON VentasArticulo.idArticulo = Articulo.idArticulo
	WHERE
		fecha LIKE '%'+@Busqueda+'%'
END
--------------------------------------------------------------------------------------------------------------------------------