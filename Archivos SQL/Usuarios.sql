ALTER PROC NuevoUsuario (
	@NombreUsuario varchar(40),
	@DireccionUsuario varchar(40),
	@Telefono int,
	@CiudadUsuario varchar(40)
)
AS
BEGIN
	INSERT INTO Usuarios (Nombre, direccion, telefono, idCiudad)
	VALUES (@NombreUsuario, @DireccionUsuario, @Telefono, (SELECT idCiudad FROM Ciudades WHERE Nombre = @CiudadUsuario));
END

EXEC NuevoUsuario 'nuevo', 'nuevo', 56578616, 'Guanajuato' 

select * from Ciudades
select * from Usuarios

DELETE FROM Ciudades WHERE idCiudad >3
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC BuscarUsuario (
	@Usuario varchar(40)
)
AS
BEGIN
	SELECT
		Nombre
	FROM
		Usuarios
	WHERE
		Nombre = @Usuario;
END

EXEC BuscarUsuario 'nuevo'
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC ModificarUsuario(
	@idUsuario int,
	@NombreUsuario varchar(40),
	@DireccionUsuario varchar(40),
	@Telefono int,
	@CiudadUsuario varchar(40)

)
AS
BEGIN
	UPDATE 
		Usuarios
	SET
		Nombre = @NombreUsuario,
		direccion = @DireccionUsuario,
		telefono = @Telefono,
		idCiudad = (SELECT idCiudad FROM Ciudades WHERE Nombre = @CiudadUsuario)
	WHERE
		idUsuario = @idUsuario;
END

EXEC ModificarUsuario 2, 'daniel', 'direccionDaniel', '1234897689', 'Ciudad Guzmán'
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC EliminarUsuario(
	@NombreUsuario varchar(40)
)
AS
	DECLARE @max INT;
BEGIN
	DELETE FROM Usuarios
	WHERE
		idUsuario = (SELECT idUsuario FROM Usuarios WHERE Nombre = @NombreUsuario);
	SELECT @MAX = max(idUsuario) from Usuarios;
	DBCC CHECKIDENT (Usuarios, RESEED, @max); -- Restablecemos el identity.
	-- Ojo: Se debe tener cuidado de utilizar cuando sólo existe un usuario, creará una excepción.
END

EXEC EliminarUsuario 'nuevo'
SELECT * FROM Usuarios
--------------------------------------------------------------------------------------------------------------------------------
DBCC CHECKIDENT (Ciudades, RESEED, 3);
--------------------------------------------------------------------------------------------------------------------------------
ALTER PROC Busqueda (
	@Usuario varchar(40)
)
AS
BEGIN
	SELECT
		idUsuario as Id,
		Usuarios.Nombre,
		direccion as Dir,
		telefono as Tel,
		Ciudades.Nombre as Cd
	FROM
		Usuarios INNER JOIN Ciudades
	ON
		Usuarios.Nombre LIKE '%'+@Usuario+'%' AND Usuarios.idCiudad = Ciudades.idCiudad
END

EXEC Busqueda 'dani'
--------------------------------------------------------------------------------------------------------------------------------
ALTER VIEW VerUsuarios
AS
	SELECT
		idUsuario as Id,
		Usuarios.Nombre,
		direccion as Dir,
		telefono as Tel,
		Ciudades.Nombre as Cd
	FROM
		Usuarios INNER JOIN Ciudades
	ON
		Usuarios.idCiudad = Ciudades.idCiudad;

SELECT * FROM VerUsuarios