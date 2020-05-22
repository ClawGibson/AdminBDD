CREATE PROC NuevaCiudad (
	@NombreCiudad varchar(40)
)
AS
BEGIN
	INSERT INTO Ciudades (Nombre)
	VALUES (@NombreCiudad)
END

EXEC NuevaCiudad 'Ciudad Guzmán'
SELECT * FROM Ciudades
------------------------------------------------------------------------------------------------------------------------
ALTER VIEW VerUsuarios
AS
SELECT 
	idUsuario as Id,
	Usuarios.Nombre,
	direccion as Dir,
	telefono as Tel,
	Ciudades.Nombre as Cd
FROM Usuarios INNER JOIN Ciudades ON Usuarios.idCiudad = Ciudades.idCiudad;

SELECT * FROM  VerUsuarios
------------------------------------------------------------------------------------------------------------------------
CREATE PROC BuscarCiudad(
	@NombreCiudad varchar(40)
)
AS
BEGIN
	SELECT 
		Nombre
	FROM
		Ciudades
	WHERE
		idCiudad = (SELECT idCiudad FROM Ciudades WHERE Nombre = @NombreCiudad)
END

EXEC BuscarCiudad 'Ciudad Guzmán'