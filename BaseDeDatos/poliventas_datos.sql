USE poliventas;

INSERT INTO Vendedores(nombreUsuario, nombre, apellido, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('daniel0ar','Daniel','Arroyo',1,'daniel0ar@hotmail.com','Terranostra','0930875299','201606381');

INSERT INTO Compradores(nombreUsuario, nombre, apellido, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('daniel0ar','Daniel','Arroyo',1,'daniel0ar@hotmail.com','Terranostra','0930875299','201606381');

INSERT INTO Vendedores(nombreUsuario, nombre, apellido, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('josedel','Jose','Delgado',1,'josedll@hotmail.com','Av 9 de Octubre y Machala','0912231981','201605312');

INSERT INTO Compradores(nombreUsuario, nombre, apellido, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('emilio880','Emilio','Arroyo',1,'emilio880@outlook.com','Terranostra','0923120810','201701010');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('iPhone 6 16G Gris','iphone en estado 8/10','tecnologia',350,1,'daniel0ar');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('CD Verano en Coma Original','CD de Da Pawn estrenado en 2015','audio',8.50,1,'daniel0ar');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Vitela para Guitarra grosor medio Fender','Vitelas de todos los colores para Guitarra clásica grosor medio Fender','audio',0.50,1,'daniel0ar');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Pendrive 8G con diseño Robot','Este unico pendrive te hara recibir comentarios de la gente','tecnologia',6,1,'daniel0ar');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Mica iPhone 6','Mica de Vidrio para iPhone 6 y 6S','tecnologia',6,1,'josedel');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionComprador, comprador, producto, tipoPago)
VALUES("2018-12-23", 3, 3, 'emilio880', 1,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionComprador, comprador, producto, tipoPago)
VALUES("2019-01-01", 4, 5, 'emilio880', 1,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionComprador, comprador, producto, tipoPago)
VALUES("2019-01-02", 4, 5, 'emilio880', 3,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionComprador, comprador, producto, tipoPago)
VALUES("2019-01-10", 5, 5, 'daniel0ar', 5,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionComprador, comprador, producto, tipoPago)
VALUES("2019-01-11", 5, 5, 'daniel0ar', 5,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionComprador, comprador, producto, tipoPago)
VALUES("2019-01-12", 5, 5, 'daniel0ar', 5,'aplicacion');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionComprador, comprador, producto, tipoPago)
VALUES("2019-01-16", 5, 5, 'emilio880', 3,'aplicacion');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionComprador, comprador, producto, tipoPago)
VALUES("2019-01-17", 5, 5, 'emilio880', 3,'aplicacion');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionComprador, comprador, producto, tipoPago)
VALUES("2019-01-17", 5, 5, 'daniel0ar', 5,'aplicacion');