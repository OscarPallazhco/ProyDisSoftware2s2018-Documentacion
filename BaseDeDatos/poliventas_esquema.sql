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
    tieneWhatsapp boolean DEFAULT 0,
    correo varchar(40) UNIQUE NOT NULL,
    direccion varchar(150),
    cedula varchar(10) UNIQUE NOT NULL,
    matricula varchar(9) UNIQUE NOT NULL,
    saldo float DEFAULT 0,
    calificacion float,
    numeroCalificaciones int DEFAULT 0,
    estado boolean DEFAULT 1,
    PRIMARY KEY(nombreUsuario)
);

CREATE TABLE Administradores(
	nombreUsuario varchar(15),
    nombre varchar(15),
    apellido varchar(15),
    tieneWhatsapp boolean DEFAULT 0,
    correo varchar(40),
    direccion varchar(150),
    cedula varchar(10),
    matricula varchar(9),
    estado boolean DEFAULT 1,
    PRIMARY KEY(nombreUsuario)
);

CREATE TABLE Usuarios(
	nombreUsuario varchar(10),
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
    calificacion float,
	numeroCalificaciones int DEFAULT 0,
    numeroBusquedas int DEFAULT 0,
    estado boolean DEFAULT 1,
    vendedor varchar(10),
    PRIMARY KEY(id)
);

CREATE TABLE Compras(
	id int AUTO_INCREMENT,
    fecha Date NOT NULL,
    entregada boolean DEFAULT 0,
    calificacionVendedor float,
    calificacionProducto float,
    numeroBusquedas int DEFAULT 0,
    estado boolean DEFAULT 1,
    tipoPago varchar(10),
    comprador varchar(15),
    producto int,
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
	IF NEW.calificacionVendedor IS NOT NULL THEN
		UPDATE Vendedores SET calificacion = (calificacion + NEW.calificacionVendedor)/numeroCalificaciones
        WHERE nombreUsuario IN (SELECT v.nombreUsuario FROM Productos p JOIN Vendedores v ON p.vendedor = v.nombreUsuario WHERE p.id= NEW.producto) ;
    END IF;
    IF NEW.calificacionProducto IS NOT NULL THEN
		UPDATE Productos SET calificacion = (calificacion + NEW.calificacionProducto)/numeroCalificaciones
        WHERE Productos.id = NEW.producto;
	END IF;
END //
DELIMITER ;

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