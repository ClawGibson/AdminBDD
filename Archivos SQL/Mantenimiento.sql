SELECT * FROM Mantenimiento;

ALTER VIEW VerMantenimiento
AS
	SELECT
		Mantenimiento.idMaquinaria,
		Maquinaria.Nombre,
		Tecnicos.Nombre as Tecnico,
		Fecha
	FROM
		(Mantenimiento INNER JOIN Tecnicos ON Mantenimiento.idTecnico = Tecnicos.idTecnico) 
		INNER JOIN Maquinaria ON Mantenimiento.idMaquinaria = Maquinaria.idMaquinaria;
	

SELECT * FROM VerMantenimiento;
SELECT * from VerTecnicos
SELECT * FROM Maquinaria
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC NuevoMantenimiento(
	@idMaq varchar(40),
	@Nombre varchar(40),
	@Fecha date
)AS
BEGIN
	INSERT INTO Mantenimiento
	VALUES ((SELECT idMaquinaria FROM Maquinaria WHERE Nombre = @idMaq), 
			(SELECT idTecnico FROM Tecnicos WHERE Nombre = @Nombre), 
			@Fecha)
END

EXEC NuevoMantenimiento 'Maq2', 'Tecnico 1', '12 mayo 2020'
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC ModificarMantenimiento(
	@idMaq varchar(40),
	@Nombre varchar(40),
	@Fecha date
)AS
BEGIN
	UPDATE Mantenimiento
	SET
		idTecnico = (SELECT idTecnico FROM Tecnicos WHERE Nombre = @Nombre),
		Fecha = @Fecha
	WHERE
		idMaquinaria = (SELECT idMaquinaria FROM Maquinaria WHERE Nombre = @idMaq)
END
--------------------------------------------------------------------------------------------------------------------------------
CREATE PROC BuscarMantenimientos(
	@Busqueda varchar(40)
)AS
BEGIN
	SELECT
		*
	FROM
		VerMantenimiento
	WHERE
		Nombre LIKE '%'+@Busqueda+'%' OR Fecha LIKE '%'+@Busqueda+'%';
END
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC EliminarMantenimiento(
	@IdMaq varchar(40),
	@Tecnico varchar(40),
	@Fecha date
)AS
BEGIN
	DELETE FROM Mantenimiento
	WHERE
		Fecha = @Fecha AND
		idMaquinaria = (SELECT idMaquinaria FROM Maquinaria WHERE Nombre = @IdMaq) AND
		idTecnico = (SELECT idTecnico FROM Tecnicos WHERE Nombre = @Tecnico);
END

EXEC EliminarMantenimiento 1, 'Poncho', '15 mayo 2020'
--------------------------------------------------------------------------------------------------------------------------------
