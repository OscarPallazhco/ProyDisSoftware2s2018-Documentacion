USE poliventas;

-- Cantidad de ventas semanales del año en curso, por tipo de pago y vendedor
SELECT (EXTRACT(WEEK FROM c.fecha)) as semana, c.tipoPago, p.vendedor, COUNT(c.id) as numeroDeVentas
FROM Compras c JOIN Productos p ON c.producto = p.id
WHERE fecha IN 
	(
	SELECT fecha FROM Compras WHERE EXTRACT(YEAR FROM fecha) = YEAR(CURRENT_DATE())
    ) 
GROUP BY semana, c.tipoPago, p.vendedor;


-- Top 10 productos más vendidos en los últimos 3 meses
SELECT p.nombre, COUNT(c.id) as numeroDeVentas
FROM Compras c JOIN Productos p ON c.producto = p.id
WHERE fecha IN 
 	(
 	SELECT fecha 
    FROM Compras 
    WHERE EXTRACT(MONTH FROM fecha) = MONTH(CURRENT_DATE()) OR 
		EXTRACT(MONTH FROM fecha) = EXTRACT(MONTH FROM DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH)) OR
        EXTRACT(MONTH FROM fecha) = EXTRACT(MONTH FROM DATE_SUB(CURRENT_DATE(), INTERVAL 2 MONTH))
   )
GROUP BY nombre
LIMIT 10;
