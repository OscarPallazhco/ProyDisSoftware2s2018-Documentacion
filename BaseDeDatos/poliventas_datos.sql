USE poliventas;

-- Datos de Vendedores

INSERT INTO Vendedores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('daniel0ar','Daniel','Arroyo','0987314478',1,'daniel0ar@hotmail.com','Terranostra mz 1614 v 31','0930875299','201606381');

INSERT INTO Vendedores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('josedel','Jose','Delgado','0972348021',1,'josedll@hotmail.com','Av 9 de Octubre y Machala','0912231981','201605312');

INSERT INTO Vendedores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('tonnyaudio','Tonny','Espinoza','0999298783',1,'anthonnyes@espol.edu.ec','Sauces 9 mz s15 v7','1029875322','201506399');

INSERT INTO Vendedores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('adalove','Andrea','Mera','0932446382',1,'amera@espol.edu.ec','Sauces 9 mz r8 v25 diagonal al mercado','0931238911','201630954');

INSERT INTO Vendedores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('rramirez','Raquel','Ramirez','0944452752',1,'rram98@outlook.com','Bellavista al frente de La Lomita','0925352339','201731997');

INSERT INTO Vendedores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('soyyandriwey','Yandri','Lopez','0921403420',1,'yandriwey@gmail.com','Sauces 9 mz r8 v25 diagonal al mercado','0925213233','201775676');

INSERT INTO Vendedores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('alexitoxd','Alexander','Remy','0991634660',1,'alexitoxd@gmail.com','Ciudadela Metropolis conjunto Rubi villa 32','0928766785','201708602');

-- Datos de Compradores


INSERT INTO Compradores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('emilio880','Emilio','Arroyo','0972298310',1,'emilio880@outlook.com','Terranostra','0923120810','201701010');

INSERT INTO Compradores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('kingJeff','Jefferson','Perez','0971988324',0,'jefito_king@outlook.com','Cdla. Naval Norte mz 15 v 3','1315255810','201899760');

INSERT INTO Compradores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('biaramo','Bianca','Ramos','0923102801',1,'bianramo@espol.edu.ec','Cdla Ceibos Norte mz 1515 v 5','093909983','201609225');

INSERT INTO Compradores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('emdelg','Emille','Delgado','0998353466',1,'delg_emil@gmail.com','Cdla Ceibos Norte mz 1615 v 2','097556655','201545340');

INSERT INTO Compradores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('davrob','David','Robles','0964645463',1,'david_tupapa@gmail.com','Jose Mascote y 9 de Octubre','092308921','201832491');

-- Datos de Administradores

INSERT INTO Administradores(nombreUsuario, nombre, apellido, telefono, tieneWhatsapp, correo, direccion, cedula, matricula)
VALUES('pepelucho','Pepe','Rodriguez','098121783',0,'pepelucho@espol.edu.ec','Kennedy Sur, circunvalacion este solar 10','1012415268','201401008');

-- Datos de Usuarios producto de usuarios registrados

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('daniel0ar','1234','vendedor');

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('josedel','4321','vendedor');

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('tonnyaudio','1111','vendedor');

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('adalove','1111','vendedor');

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('rramirez','1111','vendedor');

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('soyyandriwey','1111','vendedor');

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('alexitoxd','1111','vendedor');

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('emilio880','1234','comprador');

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('kingjeff','0000','comprador');

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('biaramo','0000','comprador');

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('emdelg','0000','comprador');

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('davrob','1234','comprador');

INSERT INTO Usuarios(nombreUsuario, contrasena, rol)
VALUES('pepelucho','7777','administrador');



-- Datos de Productos

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('iPhone 6 16G Gris','iphone en estado 8/10','tecnologia',350,1,'daniel0ar');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('CD Verano en Coma Original','CD de Da Pawn estrenado en 2015','audio',8.50,1,'daniel0ar');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Vitela para Guitarra grosor medio Fender','Vitelas de todos los colores para Guitarra clásica grosor medio Fender','audio',0.50,1,'daniel0ar');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Pendrive 8G con diseño Robot','A las chicas les encantara tu pendrive xd','tecnologia',6,1,'alexitoxd');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Mica iPhone 6 ShockProof','Mica de Vidrio para iPhone 6 y 6S','tecnologia',1.50,1,'josedel');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Mochila ergonomica para laptop Vasari','Con esta mochila tu latop esta siempre protegida. Incluye cargador solar.','tecnologia',35,10,'josedel');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Mochila Vasari vino modelo RockIt','Expresa tus gustos con esta mochila juvenil que simboliza todo lo que quieres que haga.','accesorios',20,10,'josedel');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Mochila Vasari modelo CoolKids','Llega al cole con las mejores vibras. La mochila que habla por si sola. Incluye portabotellas.','accesorios',20,10,'josedel');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Mochila Vasari azul navy Minimal','No necesitas mucho, solo esta mochila. Para los jovenes simples como tu.','accesorios',25,10,'josedel');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Mochila Vasari rojo rubi Minimal','No necesitas mucho, solo esta mochila. Para los jovenes simples como tu.','accesorios',25,10,'josedel');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Mochila Vasari ambar wood Minimal','No necesitas mucho, solo esta mochila. Para los jovenes simples como tu.','accesorios',25,10,'josedel');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Funda antiagua WatProf para celulares. Universal','Lleva tu celular a cualquier viaje de aventura con su funda antiagua. Sirve para cualquier modelo de celular.','accesorios',18,3,'josedel');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Ukelele Ibanez soprano','Ukelele soprano dela mejor marca y calidad. Madera roble frances. Para todo amante de las cuerdas.','audio',85,5,'adalove');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Cuerdas ukelele metalicas','Dale un toque elctrico a tu ukelelecon estas cuerdas metalicas delarga duracion. Conecta tu ukelele a un amplificador y veras la magia','audio',8.50,1,'adalove');

INSERT INTO Productos(nombre,descripcion,categoria,precio,tiempoEntrega, vendedor)
VALUES ('Zapatos Vans slip on diseño B/N','Originales Vans traidos desde USA','ropa',40,2,'rramirez');

-- Datos de Compras

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2018-12-23", 3, 3, 'emilio880', 1,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2017-12-25", 3, 5, 'kingjeff', 5,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2017-12-25", 0, 5, 'kingjeff', 5,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-01", 4, 5, 'emilio880', 1,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-02", 4, 5, 'emilio880', 5,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-10", 5, 5, 'daniel0ar', 5,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-11", 5, 5, 'daniel0ar', 5,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-12", 5, 5, 'daniel0ar', 8,'aplicacion');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-16", 5, 5, 'emilio880', 3,'aplicacion');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-17", 5, 5, 'emilio880', 3,'aplicacion');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-17", 2, 5, 'daniel0ar', 14,'aplicacion');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-18", 4, 5, 'emdelg', 12,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-19", 5, 5, 'emdelg', 12,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-20", 5, 3, 'emdelg', 5,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-22", 5, 3, 'emdelg', 5,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-22", 5, 3, 'davrob', 7,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-01-25", 1, 4, 'adalove', 7,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-02-01", 1, 4, 'adalove', 9,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-02-01", 4, 4, 'biaramo', 10,'efectivo');

INSERT INTO Compras(fecha, calificacionVendedor, calificacionProducto, comprador, producto, tipoPago)
VALUES("2019-02-01", 4, 5, 'rramirez', 10,'aplicacion');
