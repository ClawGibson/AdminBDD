SELECT * FROM Maquinaria;

CREATE PROC NuevaMaquinaria(
	@Nombre varchar(40)
)AS
BEGIN
	INSERT INTO Maquinaria (Nombre)
	VALUES (@Nombre);
END

EXEC NuevaMaquinaria 'Maq4';
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC ModificarMaquinaria(
	@Id int,
	@Nombre varchar(40)
)AS
BEGIN
	UPDATE Maquinaria
	SET
		Nombre = @Nombre
	WHERE
		idMaquinaria = @Id;
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC BuscarMaquinaria(
	@Nombre varchar(40)
)AS
BEGIN
	SELECT
		Nombre
	FROM
		Maquinaria
	WHERE
		Nombre = @Nombre;
END
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC EliminarMaquinaria(
	@Nombre varchar(40)
)AS
BEGIN
	DELETE FROM Maquinaria
	WHERE idMaquinaria = (SELECT idMaquinaria FROM Maquinaria WHERE Nombre = @Nombre);
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE VIEW VerMaquinaria
AS
	SELECT
		Nombre
	FROM
		Maquinaria;

SELECT * FROM VerMaquinaria