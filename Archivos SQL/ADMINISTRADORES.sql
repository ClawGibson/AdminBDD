USE PUNTO18ARQUITECTOS

---CREACION DE ADMINISTRADORES---
CREATE LOGIN gama
WITH PASSWORD = 'gama',
default_database=PUNTO18ARQUITECTOS

-----CREACION DE USUARIO ADMINISTRADOR
CREATE USER admingama
FOR LOGIN gama
WITH default_schema=esquema

------creacion de esquema para administrador

CREATE SCHEMA esquema AUTHORIZATION admingama;

-----creacion de privilegios para administrador--
GRANT CREATE PROC,EXECUTE,CREATE TABLE, CREATE ROLE, SELECT,INSERT,UPDATE,DELETE TO admingama;