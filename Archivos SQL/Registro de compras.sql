ALTER PROC VerInfoCompras(
		@Busqueda varchar(40)
)AS
BEGIN
	SELECT
		Compras.idCompra,
		ComprasArticulo.idArticulo,
		Articulo.nombre,
		cantidad,
		precio,
		total,
		Compras.fecha
	FROM
		Compras INNER JOIN ComprasArticulo ON Compras.idCompra = ComprasArticulo.idCompra
		INNER JOIN Articulo ON ComprasArticulo.idArticulo = Articulo.idArticulo
	WHERE
		fecha LIKE '%'+@Busqueda+'%' AND total IS NOT null
	ORDER BY fecha DESC;
END
--------------------------------------------------------------------------------------------------------------------------------
ALTER VIEW InfoCompras AS
SELECT
		Compras.idCompra,
		ComprasArticulo.idArticulo,
		Articulo.nombre,
		cantidad,
		precio,
		total,
		Compras.fecha
	FROM
		Compras INNER JOIN ComprasArticulo ON Compras.idCompra = ComprasArticulo.idCompra
		INNER JOIN Articulo ON ComprasArticulo.idArticulo = Articulo.idArticulo
	WHERE
		total IS NOT null;