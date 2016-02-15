DELIMITER $$
CREATE PROCEDURE saveproductosventa(in idven int, in idpro int)
BEGIN
	INSERT INTO transacciones_has_productos values (idven,idpro);
END$$
DELIMITER ;

select * from transacciones_has_productos;