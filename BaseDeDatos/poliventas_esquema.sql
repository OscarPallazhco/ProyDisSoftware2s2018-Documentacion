DROP DATABASE IF EXISTS poliventas;
CREATE DATABASE poliventas;
USE poliventas;

CREATE TABLE Compradores(
	nombreUsuario varchar(15),
    nombre varchar(15) NOT NULL,
    apellido varchar(15) NOT NULL,
    telefono varchar(10) NOT NULL,
    tieneWhatsapp boolean DEFAULT 0,
    correo varchar(40) UNIQUE NOT NULL,
    direccion varchar(150),
    cedula varchar(10) UNIQUE NOT NULL,
    matricula varchar(9) UNIQUE NOT NULL,
    saldo float DEFAULT 0,
    estado boolean DEFAULT 1,
    PRIMARY KEY(nombreUsuario)
);

CREATE TABLE Vendedores(
	nombreUsuario varchar(15),
    nombre varchar(15) NOT NULL,
    apellido varchar(15) NOT NULL,
    telefono varchar(10) NOT NULL,
    tieneWhatsapp boolean DEFAULT 0,
    correo varchar(40) UNIQUE NOT NULL,
    direccion varchar(150),
    cedula varchar(10) UNIQUE NOT NULL,
    matricula varchar(9) UNIQUE NOT NULL,
    saldo float DEFAULT 0,
    calificacion float DEFAULT 0,
    numeroCalificaciones int DEFAULT 0,
    estado boolean DEFAULT 1,
    PRIMARY KEY(nombreUsuario)
);

CREATE TABLE Administradores(
	nombreUsuario varchar(15),
    nombre varchar(15) NOT NULL,
    apellido varchar(15) NOT NULL,
    telefono varchar(10) NOT NULL,
    tieneWhatsapp boolean DEFAULT 0,
    correo varchar(40) UNIQUE NOT NULL,
    direccion varchar(150),
    cedula varchar(10) UNIQUE NOT NULL,
    matricula varchar(9) UNIQUE NOT NULL,
    estado boolean DEFAULT 1,
    PRIMARY KEY(nombreUsuario)
);

CREATE TABLE Usuarios(
	nombreUsuario varchar(15),
    contrasena varchar(30),
    rol varchar(20),
    PRIMARY KEY(nombreUsuario)
);

CREATE TABLE Productos(
	id int AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
	descripcion varchar(500),
    categoria varchar(10),
    precio float NOT NULL,
    tiempoEntrega int,
    calificacion float DEFAULT 0,
	numeroCalificaciones int DEFAULT 0,
    numeroBusquedas int DEFAULT 0,
    estado boolean DEFAULT 1,
    vendedor varchar(10),
    PRIMARY KEY(id),
    FOREIGN KEY(vendedor) REFERENCES Vendedores(nombreUsuario)
);

CREATE TABLE Compras(
	id int AUTO_INCREMENT,
    fecha Date NOT NULL,
    entregada boolean DEFAULT 0,
    calificacionVendedor float,
    calificacionProducto float,
    estado boolean DEFAULT 1,
    tipoPago varchar(10) NOT NULL,
    comprador varchar(15) NOT NULL,
    producto int NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(comprador) REFERENCES Compradores(nombreUsuario),
	FOREIGN KEY(producto) REFERENCES Productos(id)
);

DELIMITER $$
DROP PROCEDURE IF EXISTS ingresarComprador$$
CREATE PROCEDURE ingresarComprador(nombreUsuario varchar(15),nombre VARCHAR(50),apellido varchar(20),tieneWhatsapp boolean,correo varchar(30),
direccion varchar(30),cedula varchar(10),matricula varchar(9))
BEGIN
INSERT INTO Compradores (nombreUsuario,nombre,apellido,tieneWhatsapp,correo,direccion,cedula,matricula)
 VALUES(nombreUsuario,nombre,apellido,tieneWhatsapp,correo,direccion,cedula,matricula);
END$$

DELIMITER $$
DROP PROCEDURE IF EXISTS ingresarVendedor$$
CREATE PROCEDURE ingresarVendedor(nombreUsuario varchar(15),nombre VARCHAR(50),apellido varchar(20),tieneWhatsapp boolean,correo varchar(30),
direccion varchar(30),cedula varchar(10),matricula varchar(9))
BEGIN
INSERT INTO Vendedores (nombreUsuario,nombre,apellido,tieneWhatsapp,correo,direccion,cedula,matricula)
 VALUES(nombreUsuario,nombre,apellido,tieneWhatsapp,correo,direccion,cedula,matricula);
END$$

DELIMITER $$
DROP PROCEDURE IF EXISTS guardarProducto$$
CREATE PROCEDURE guardarProducto(nombre varchar(50),descripcion VARCHAR(500),categoria varchar(10),precio float,tiempoEntrega int,
vendedor varchar(10))
BEGIN
INSERT INTO Productos (nombre,descripcion,categoria,precio,tiempoEntrega,vendedor)
 VALUES(nombre,descripcion,categoria,precio,tiempoEntrega,vendedor);
END$$

DELIMITER $$
DROP PROCEDURE IF EXISTS actualizarBusqueda$$
CREATE PROCEDURE actualizarBusqueda(iduser int)
BEGIN
update Productos set numeroBusquedas=numeroBusquedas+1 where id=iduser ;
END$$

DELIMITER $$
DROP PROCEDURE IF EXISTS eliminarProducto$$
CREATE PROCEDURE eliminarProducto(iduser int)
BEGIN
update Productos set estado=0 where id=iduser ;
END$$


DELIMITER //
CREATE TRIGGER trig_actualizarCalificacion BEFORE INSERT 
ON Compras FOR EACH ROW
BEGIN
	SET SQL_SAFE_UPDATES = 0;
	IF NEW.calificacionVendedor IS NOT NULL THEN
		UPDATE Vendedores SET numeroCalificaciones = numeroCalificaciones+1
        WHERE nombreUsuario IN (SELECT vendedor FROM Productos WHERE id= NEW.producto) ;
		UPDATE Vendedores SET calificacion = (calificacion*(numeroCalificaciones-1) + NEW.calificacionVendedor)/numeroCalificaciones
        WHERE nombreUsuario IN (SELECT vendedor FROM Productos WHERE id= NEW.producto) ;
    END IF;
    IF NEW.calificacionProducto IS NOT NULL THEN
		UPDATE Productos SET numeroCalificaciones = numeroCalificaciones+1
        WHERE Productos.id = NEW.producto;
		UPDATE Productos SET calificacion = (calificacion*(numeroCalificaciones-1) + NEW.calificacionProducto)/numeroCalificaciones
        WHERE Productos.id = NEW.producto;
	END IF;
    SET SQL_SAFE_UPDATES = 1;
END //
DELIMITER ;

CREATE TRIGGER trig_insertarVendedorComprador BEFORE INSERT 
ON Vendedores FOR EACH ROW
	INSERT INTO Compradores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula) 
	VALUES(NEW.nombreUsuario, NEW.nombre, NEW.apellido, NEW.telefono, NEW.tieneWhatsapp, NEW.correo, NEW.direccion, NEW.cedula, NEW.matricula);

CREATE VIEW productosMasBuscados AS
SELECT nombre, calificacion, categoria, vendedor 
FROM Productos 
ORDER BY numeroBusquedas DESC 
LIMIT 20;

CREATE VIEW productosNuevos AS
SELECT nombre, calificacion, categoria, vendedor 
FROM Productos 
ORDER BY id DESC
LIMIT 20;
