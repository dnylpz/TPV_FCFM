select * from detalle;
select * from formasdepago;
select * from transacciones_has_productos;
select * from productos;
select * from promociones;
select * from usuarios;

select * from reporte;

DELIMITER $$
create procedure getReportefechas(in inic Date, in fin date)
BEGIN
   select idDetalle, loginUsuario, CONCAT(nombreUsuario, ' ',apellidosUsuario) usuario,
    fechaDetalle, horaDetalle, total, nombreFormaDePago, nombreProducto,
    precioProducto, impuesto, tipoPromocion, valorPromocion, vigencia, ROUND(sum(precioProducto),2) subtotal,
    count(*) productos_vendidos
    from reporte where fechaDetalle between inic and fin group by idDetalle ;
END$$
DELIMITER ;