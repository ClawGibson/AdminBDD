SELECT * FROM ComprasArticulo;

CREATE PROC NuevaCompra( -- Inicia una compra.
	@Fecha date
)AS
BEGIN
	INSERT INTO Compras (fecha) VALUES (@Fecha);
END
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC NuevaCompra2( -- Carrito de compra.
	@Articulo varchar(40),
	@Cantidad float
)AS
BEGIN
	INSERT INTO ComprasArticulo 
	VALUES ((SELECT TOP 1 idCompra FROM Compras ORDER BY idCompra DESC), 
			(SELECT idArticulo FROM Articulo WHERE nombre = @Articulo),
			@Cantidad);
END
SELECT * FROM ComprasArticulo
EXEC VerCarritoCompra 5
EXEC NuevaCompra2 'Leche 1Lt', 1.0
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC NuevaCompra3( -- Finalización de la compra.
	@Total float
)AS
BEGIN
	UPDATE Compras
	SET
		total = @Total
	WHERE
		idCompra = (SELECT TOP 1 idCompra FROM Compras ORDER BY idCompra DESC);
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC EliminarArticuloDeCompra(
	@id int,
	@Articulo varchar(40)
)AS
BEGIN
	DELETE FROM ComprasArticulo
	WHERE
		idArticulo = (SELECT idArticulo FROM Articulo WHERE nombre = @Articulo) AND
		idCompra = @id;
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE VIEW ObtenerIdCompra
AS
	SELECT TOP 1 idCompra FROM Compras ORDER BY idCompra DESC;
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC VerCarritoCompra(
	@Id int
)AS
BEGIN
	SELECT
		Compras.idCompra,
		ComprasArticulo.idArticulo,
		Articulo.nombre,
		cantidad,
		precio
	FROM
		Compras INNER JOIN ComprasArticulo ON Compras.idCompra = ComprasArticulo.idCompra
		INNER JOIN Articulo ON ComprasArticulo.idArticulo = Articulo.idArticulo
	WHERE
		Compras.idCompra = @Id;
END
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
