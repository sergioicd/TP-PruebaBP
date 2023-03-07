INSERT INTO `pichincha`.`cliente`(`direccion`,`genero`,`identificacion`,`nombre`,`telefono`,`contrasena_cliente`,`estado_cliente`)VALUES('Calle 1 carrera 2','masculino','80123456','Miguel','300123456','password123456',true);
INSERT INTO `pichincha`.`cliente`(`direccion`,`genero`,`identificacion`,`nombre`,`telefono`,`contrasena_cliente`,`estado_cliente`)VALUES('Calle 2 carrera 3','femenino','80789012','Maria','300789012','password789012',true);
INSERT INTO `pichincha`.`cliente`(`direccion`,`genero`,`identificacion`,`nombre`,`telefono`,`contrasena_cliente`,`estado_cliente`)VALUES('Calle 3 carrera 4','masculino','80345678','Jose','300345678','password345678',true);


INSERT INTO `pichincha`.`cuenta`(`estado_cuenta`,`numero_cuenta`,`saldo_inicial_cuenta`,`tipo_cuenta`,`fk_cliente_id`)VALUES(true,'900123456','1000000','ahorros',1);
INSERT INTO `pichincha`.`cuenta`(`estado_cuenta`,`numero_cuenta`,`saldo_inicial_cuenta`,`tipo_cuenta`,`fk_cliente_id`)VALUES(true,'500123456','2000000','corriente',1);
INSERT INTO `pichincha`.`cuenta`(`estado_cuenta`,`numero_cuenta`,`saldo_inicial_cuenta`,`tipo_cuenta`,`fk_cliente_id`)VALUES(true,'900789012','5000000','ahorros',2);
INSERT INTO `pichincha`.`cuenta`(`estado_cuenta`,`numero_cuenta`,`saldo_inicial_cuenta`,`tipo_cuenta`,`fk_cliente_id`)VALUES(true,'900345678','3000000','ahorros',3);

INSERT INTO `pichincha`.`movimiento`(`fecha_movimiento`,`saldo`,`tipo_movimiento`,`valor_movimiento`,`fk_cuenta_id`)VALUES('2023-03-05 09:45:00',1000000,'Retiro',800000,1);
