INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(1,'Andres','Guzman','plas@gmail.com','2019-05-25');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(2,'Pepe','Mariagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(3,'123','Mariagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(4,'zxz','fb','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(5,'Peeterpe','ryuyweqt','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(6,'Peptyuyte','Masfdsfdsriagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(7,'kjljk','Marzvbvcxvzxciagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(8,'zxz','fb','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(9,'Peeterpe','ryuyweqt','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(10,'Peptyuyte','Masfdsfdsriagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(11,'kjljk','Marzvbvcxvzxciagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(12,'zxz','fb','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(13,'Peeterpe','ryuyweqt','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(14,'Peptyuyte','Masfdsfdsriagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(15,'kjljk','Marzvbvcxvzxciagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(16,'zxz','fb','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(17,'Peeterpe','ryuyweqt','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(18,'Peptyuyte','Masfdsfdsriagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(19,'kjljk','Marzvbvcxvzxciagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(20,'zxz','fb','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(21,'Peeterpe','ryuyweqt','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(22,'Peptyuyte','Masfdsfdsriagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(23,'kjljk','Marzvbvcxvzxciagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(24,'zxz','fb','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(25,'Peeterpe','ryuyweqt','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(26,'Peptyuyte','Masfdsfdsriagr','pronq@gmail.com','2017-02-01');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(27,'kjljk','Marzvbvcxvzxciagr','pronq@gmail.com','2017-02-01');


/* Inyectamos 2 usuario para hacer el login. */
INSERT INTO users (username, password, enabled) VALUES ('jose','$2a$10$Rs431XSXPZc3vvX8vLFQCerQTpfitN4Q4HkQlyRaQslXJWh6tXvrq',1);
INSERT INTO users (username, password, enabled) VALUES ('admin','$2a$10$Cr8senR9U/STePC/oCGfu.SVdaBnQ9bGXpymRbHICD5gTdD9hFV7y',1);

/* Inyectamos los roles de los usuarios */
INSERT INTO roles (user_id, rol) VALUES (1, 'ROLE_USER');
INSERT INTO roles (user_id, rol) VALUES (2, 'ROLE_USER');
INSERT INTO roles (user_id, rol) VALUES (2, 'ROLE_ADMIN');

