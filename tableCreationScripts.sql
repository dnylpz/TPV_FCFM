CREATE TABLE IF NOT EXISTS `TPV_FCFM`.`Empresa` (
  `idEmpresa` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nombreEmpresa` VARCHAR(45) NULL COMMENT '',
  `RFCEmpresa` VARCHAR(13) NULL COMMENT '',
  `logoEmpresa` BLOB NULL COMMENT '',
  PRIMARY KEY (`idEmpresa`)  COMMENT '')
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `TPV_FCFM`.`Usuarios` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `loginUsuario` VARCHAR(45) NOT NULL COMMENT '',
  `passwordUsuario` VARCHAR(45) NOT NULL COMMENT '',
  `ultimoAccesoUsuario` DATETIME NULL COMMENT '',
  `fotoUsuario` BLOB NULL COMMENT '',
  `administrador` TINYINT(1) NULL COMMENT '',
  `nombreUsuario` VARCHAR(45) NULL COMMENT '',
  `apellidosUsuario` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`idUsuario`)  COMMENT '')
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `TPV_FCFM`.`clientes` (
  `idCliente` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nombreCliente` VARCHAR(45) NULL COMMENT '',
  `apellidoCliente` VARCHAR(45) NULL COMMENT '',
  `fotoCliente` BLOB NULL COMMENT '',
  `puntosCliente` INT NULL COMMENT '',
  PRIMARY KEY (`idCliente`)  COMMENT '')
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `TPV_FCFM`.`Tiendas` (
  `idTienda` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `direccionTienda` VARCHAR(45) NULL COMMENT '',
  `gerenteTiendaFK` INT NULL COMMENT '',
  `empresaTiendaFK` INT NULL COMMENT '',
  PRIMARY KEY (`idTienda`)  COMMENT '',
  INDEX `gerenteTiendaFK_idx` (`gerenteTiendaFK` ASC)  COMMENT '',
  INDEX `empresaTiendaFK_idx` (`empresaTiendaFK` ASC)  COMMENT '',
  CONSTRAINT `gerenteTiendaFK`
    FOREIGN KEY (`gerenteTiendaFK`)
    REFERENCES `TPV_FCFM`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `empresaTiendaFK`
    FOREIGN KEY (`empresaTiendaFK`)
    REFERENCES `TPV_FCFM`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `TPV_FCFM`.`Videos` (
  `idVideo` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `VideoBlob` BLOB NULL COMMENT '',
  PRIMARY KEY (`idVideo`)  COMMENT '')
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `TPV_FCFM`.`Productos` (
  `idProductos` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nombreProducto` VARCHAR(45) NOT NULL COMMENT '',
  `descripcionProducto` VARCHAR(250) NULL COMMENT '',
  `UPC` INT NULL COMMENT '',
  `imagenProducto` BLOB NULL COMMENT '',
  `precioProducto` DECIMAL(6,2) NULL COMMENT '',
  `transaccionFK` INT NULL COMMENT '',
  PRIMARY KEY (`idProductos`)  COMMENT '')
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `TPV_FCFM`.`ProductosTransaccionPIV` (
  `idproductosTransaccion` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `transaccionFK` INT NULL COMMENT '',
  `productoFK` INT NULL COMMENT '',
  PRIMARY KEY (`idproductosTransaccion`)  COMMENT '',
  INDEX `productoFk_idx` (`productoFK` ASC)  COMMENT '',
  CONSTRAINT `productoFk`
    FOREIGN KEY (`productoFK`)
    REFERENCES `TPV_FCFM`.`Productos` (`idProductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf32;
CREATE TABLE IF NOT EXISTS `TPV_FCFM`.`Transacciones` (
  `idTransaccion` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `productosTransaccion` INT NULL COMMENT '',
  `fechaHoraTransaccion` DATETIME NULL COMMENT '',
  `formaDePago` VARCHAR(3) NULL COMMENT '',
  `totalTransaccion` FLOAT NULL COMMENT '',
  `productosFK` INT NULL COMMENT '',
  `usuarioFK` INT NULL COMMENT '',
  `clienteFK` INT NULL COMMENT '',
  `tiendaFK` INT NULL COMMENT '',
  PRIMARY KEY (`idTransaccion`)  COMMENT '',
  INDEX `productosFK_idx` (`productosFK` ASC)  COMMENT '',
  INDEX `usuarioFK_idx` (`usuarioFK` ASC)  COMMENT '',
  INDEX `clienteFK_idx` (`clienteFK` ASC)  COMMENT '',
  INDEX `tiendaFK_idx` (`tiendaFK` ASC)  COMMENT '',
  CONSTRAINT `productosFK`
    FOREIGN KEY (`productosFK`)
    REFERENCES `TPV_FCFM`.`ProductosTransaccionPIV` (`idproductosTransaccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `usuarioFK`
    FOREIGN KEY (`usuarioFK`)
    REFERENCES `TPV_FCFM`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `clienteFK`
    FOREIGN KEY (`clienteFK`)
    REFERENCES `TPV_FCFM`.`clientes` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tiendaFK`
    FOREIGN KEY (`tiendaFK`)
    REFERENCES `TPV_FCFM`.`Tiendas` (`idTienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `TPV_FCFM`.`Cajas` (
  `idCaja` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `activa` TINYINT(1) NULL COMMENT '',
  `dineroCaja` FLOAT NULL COMMENT '',
  `videoActivoFK` INT NULL COMMENT '',
  `tiendaCajaFK` INT NULL COMMENT '',
  `ultimaTrasanccionFK` INT NULL COMMENT '',
  `ultimoActivoFK` INT NULL COMMENT '',
  `usuarioActivoFK` INT NULL COMMENT '',
  PRIMARY KEY (`idCaja`)  COMMENT '',
  INDEX `ultimoActivo_idx` (`ultimoActivoFK` ASC)  COMMENT '',
  INDEX `usuarioActivoFK_idx` (`usuarioActivoFK` ASC)  COMMENT '',
  INDEX `ultimaTrasaccionFK_idx` (`ultimaTrasanccionFK` ASC)  COMMENT '',
  INDEX `tiendaCajaFK_idx` (`tiendaCajaFK` ASC)  COMMENT '',
  INDEX `videoCajaFK_idx` (`videoActivoFK` ASC)  COMMENT '',
  CONSTRAINT `ultimoActivoFK`
    FOREIGN KEY (`ultimoActivoFK`)
    REFERENCES `TPV_FCFM`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `usuarioActivoFK`
    FOREIGN KEY (`usuarioActivoFK`)
    REFERENCES `TPV_FCFM`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ultimaTrasaccionFK`
    FOREIGN KEY (`ultimaTrasanccionFK`)
    REFERENCES `TPV_FCFM`.`Transacciones` (`idTransaccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tiendaCajaFK`
    FOREIGN KEY (`tiendaCajaFK`)
    REFERENCES `TPV_FCFM`.`Tiendas` (`idTienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `videoCajaFK`
    FOREIGN KEY (`videoActivoFK`)
    REFERENCES `TPV_FCFM`.`Videos` (`idVideo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

