insert into usuario (nombre_usuario, password_usuario, apellidos_usuario, email_usuario, fechanac_usuario, numtarjeta_usuario, titular_usuario, codseg_usuario, direcfact_usuario) 
values ('admin','$2a$10$w3gWFIrpd9tBjWqSuBk5POL/0nbLbNgtUdrZqkU3e4./4uuGt7mZy', 'admin', 'admin@admin.es', '1/enero/2020', '666', 'administrator', '666', 'deepweb');
-- Pass1234

insert into usuario (nombre_usuario, password_usuario, apellidos_usuario, email_usuario, fechanac_usuario, numtarjeta_usuario, titular_usuario, codseg_usuario, direcfact_usuario)
values ('Danielus', '$2a$10$PFrD3YbfQj4JY0FmQjfROOOrT.v5CrZ8UuCeGlEat4ZbP2wlciEly','Master','meme@meme.es','16/noviembre/1994','000','XXX','619','Andalasia');
-- Passlolo

insert into usuario (nombre_usuario, password_usuario, apellidos_usuario, email_usuario, fechanac_usuario, numtarjeta_usuario, titular_usuario, codseg_usuario, direcfact_usuario)
values ('Amanduski', '$2a$10$lNvF8jqyBas9JX7lSoVctONA8HgzOh7NvJbDifjs7oNLFHNOJho8a','Chachi','mecago@entoh.es','19/mayo/1992','888','Amanduski','666','Calle Desengano 21');
-- Pass1234


insert into rol (id_rol, nombre_rol) values (1,'admin');
insert into rol (id_rol, nombre_rol) values (2, 'registrado');

insert into usuario_rol (id_usuario, id_rol) values (1,1);
insert into usuario_rol (id_usuario, id_rol) values (2,2);
insert into usuario_rol (id_usuario, id_rol) values (3,2);

--VIDEOS

--Abdominales
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (1,'Ejercicios para abdomen | 12 minutos', 0, 'https://www.youtube.com/embed/2tXQbi16EdI');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (2,'Rutina intensa de abdomen para un vientre plano | 8 minutos', 0, 'https://www.youtube.com/embed/Pvxj-1dgVk0');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (3,'Ejercicios abdomen fuerte | 10 minutos', 0, 'https://www.youtube.com/embed/GohgTclrnFk');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (4,'Ejercicios para abdomen y cintura en casa | 10 minutos', 0, 'https://www.youtube.com/embed/u51ytLWD15g');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (5,'Abdominales de pie | 20 minutos', 0, 'https://www.youtube.com/embed/JWCG90eOvqA');


--Piernas
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (6,'Ejercicios para piernas en casa', 1, 'https://www.youtube.com/embed/HNosAVcpsz4');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (7,'Rutina rápida y eficaz para piernas | 10 minutos', 1, 'https://www.youtube.com/embed/KrpKmehR--A');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (8,'Piernas delgadas | 10 minutos', 1, 'https://www.youtube.com/embed/5vvkxPuHN1s');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (9,'Parte interna del muslo | Ejercicios para piernas en casa', 1, 'https://www.youtube.com/embed/3YfWmbBfeLA');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (10,'Los mejores ejercicios para tonificar piernas y glúteos', 1, 'https://www.youtube.com/embed/E8LcNwTotK4');

--Gluteos
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (11,'Rutina para aumentar y tener unos glúteos grandes y bonitos', 2, 'https://www.youtube.com/embed/wL87zJ6wgxw');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (12,'Los mejores ejercicios para subir glúteos rápidamente', 2, 'https://www.youtube.com/embed/y4nfst53MJ0');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (13,'Rutina intensa glúteos perfectos', 2, 'https://www.youtube.com/embed/6RazpkazXzo');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (14,'Ejercicios para aumentar glúteos | 25 minutos', 2, 'https://www.youtube.com/embed/yGXwjAoQciQ');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (15,'Rutina para aumentar glúteos | 15 minutos', 2, 'https://www.youtube.com/embed/lczlQ_0dK8c');

--Espalda
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (16,'Ejercicios para la espalda | 10 minutos', 3, 'https://www.youtube.com/embed/cWyvrxq8dB0');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (17,'Tabla de espalda y rutina de ejercicios para una espalda sana', 3, 'https://www.youtube.com/embed/4J4wZcgMA_E');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (18,'Ejercicios para aliviar el dolor de espalda, cervical y ciática', 3, 'https://www.youtube.com/embed/NtT1P6tu8yY');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (19,'Rutina de ejercicios para la espalda con mancuernas', 3, 'https://www.youtube.com/embed/8oYEDTeihuA');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (20,'Fortalecer los lumbares y espalda | 9 minutos', 3, 'https://www.youtube.com/embed/YcvyxYzGJbc');

--Brazos
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (21,'Ejercicios para brazos, bíceps y tríceps | 8 minutos', 4, 'https://www.youtube.com/embed/ZIm_qrJSOds');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (22,'Reto brazos de 28 días | Brazos perfectos y delgados', 4, 'https://www.youtube.com/embed/safLKLi_7xk');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (23,'Ejercicios para brazos flácidos mujeres', 4, 'https://www.youtube.com/embed/k4QS7WAxjkE');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (24,'Rutina tonificación brazos | 15 minutos', 4, 'https://www.youtube.com/embed/DZpHqtGqeIE');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (25,'Los mejores ejercicios para adelgazar brazos', 4, 'https://www.youtube.com/embed/fFRzON_ihVY');

--FullBody
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (26,'Full body workout | 30 minutos', 5, 'https://www.youtube.com/embed/5vzvua0Yhy8');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (27,'Rutina full body', 5, 'https://www.youtube.com/embed/NKvj2q0Xe6w');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (28,'Entrenamiento para principiantes | Total body', 5, 'https://www.youtube.com/embed/q9b9afJ-GnA');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (29,'Los mejores ejercicios para el cuerpo en casa | 6 minutos', 5, 'https://www.youtube.com/embed/Ga_3N8Pgcno');
insert into video (id_multimedia, nombre_multimedia, categoria_video, link_video) values (30,'Rutina de ejercicios full body para tonificar', 5, 'https://www.youtube.com/embed/wWCphTqdFkw');
