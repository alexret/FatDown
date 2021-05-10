drop database if exists FatDown;
create database FatDown;

use FatDown;
    
        create table usuario (
       	 id_usuario bigint not null auto_increment,
         apellidos_usuario varchar(255),
         codseg_usuario varchar(255),
         direcfact_usuario varchar(255),
         email_usuario varchar(255),
         fechanac_usuario varchar(255),
         nombre_usuario varchar(255),
         -- username varchar (255),
         numtarjeta_usuario varchar(255),
         password_usuario varchar(255),
         titular_usuario varchar(255),
         primary key (id_usuario),
         unique key unique_email (email_usuario)
    ) ;
    
	    create table rol (
	     id_rol int auto_increment,
	     nombre_rol varchar (40) not null,
	     primary key (id_rol)
	);
	
		create table usuario_rol (
	     id_usuario bigint not null,
	     id_rol int,
	     primary key (
	      id_usuario,
	      id_rol
	     ),
		 constraint fk_usuario_rol_1 foreign key (id_usuario) references usuario (id_usuario) on delete cascade,
		 constraint fk_usuario_rol_2 foreign key (id_rol) references rol (id_rol)
	);
