SELECT * FROM Tecnicos

ALTER  PROC Buscador(
	@Nombre varchar(40)
)
AS
BEGIN
	SELECT
		Tecnicos.idTecnico as Id,
		Tecnicos.Nombre,
		telefono as Tel,
		Ciudades.Nombre as Cd
	FROM
		Tecnicos INNER JOIN Ciudades
	ON
		Tecnicos.Nombre LIKE '%'+@Nombre+'%' AND Tecnicos.idCiudad = Ciudades.idCiudad;
END

EXEC Buscador 'o'
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC NuevoTecnico(
	@Nombre varchar(40),
	@Telefono int,
	@Ciudad varchar(40)
)
AS
BEGIN
	INSERT INTO Tecnicos (Nombre, telefono, idCiudad)
	VALUES (@Nombre, @Telefono, (SELECT idCiudad FROM Ciudades WHERE Nombre = @Ciudad))
END

EXEC NuevoTecnico 'Poncho', 123456798, 'Zapotlán'
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC ModificarTecnico(
	@id int,
	@Nombre varchar(40),
	@Telefono int,
	@Ciudad varchar(40)
)
AS
BEGIN
	UPDATE Tecnicos
	SET
		Nombre = @Nombre,
		telefono = @Telefono,
		idCiudad = (SELECT idCiudad FROM Ciudades WHERE Nombre = @Ciudad)
	WHERE
		idTecnico = @id
END
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC EliminarTecnico(
	@Nombre varchar(40)
)
AS
BEGIN
	DELETE FROM Tecnicos
	WHERE
		idTecnico = (SELECT idTecnico FROM Tecnicos WHERE Nombre = @Nombre)
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE VIEW VerTecnicos
AS
	SELECT
		idTecnico as Id,
		Tecnicos.Nombre,
		telefono as Tel,
		Ciudades.Nombre as Cd
	FROM
		Tecnicos INNER JOIN Ciudades
	ON
		Tecnicos.idCiudad = Ciudades.idCiudad;

SELECT * FROM VerTecnicos
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC BuscarTecnico(
	@Nombre varchar(40)
)
AS
BEGIN
	SELECT
		Nombre
	FROM
		Tecnicos
	WHERE
		idTecnico = (SELECT idTecnico FROM Tecnicos WHERE Nombre = @Nombre);
END

EXEC BuscarTecnico 'Tecnico 1'