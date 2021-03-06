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
	
		create table consejo (
		    id_consejo bigint not null auto_increment,
		    nombre_consejo varchar(50) not null,
		    descripcion_consejo varchar(255) not null,
		    primary key (id_consejo)				
    ) ;
	
		create table imagen (
	       	 id_multimedia bigint not null auto_increment,
	         nombre_multimedia varchar(50) not null,
	         multimedia longblob not null,
	        -- id_consejo bigint not null,
	         primary key (id_multimedia)
			--constraint fk_imagen_consejo foreign key (id_consejo) references consejo (id_consejo) on update cascade
    ) ;

    	create table video (
	       	 id_multimedia bigint not null auto_increment,
	         nombre_multimedia varchar(255) not null,
	         categoria_video integer not null,
	        link_video varchar (255) not null,
	         id_usuario bigint,
	         primary key (id_multimedia),
	         constraint fk_video_usuario
        foreign key (id_usuario) references usuario (id_usuario)
		on update cascade

    ) ;
        	create table ejercicio (
    	       	 ID_EJERCICIO bigint not null auto_increment,
    	         nombre_ejercicio varchar(50) not null,
                 descripcion_ejercicio varchar(2000) not null,
                 categoria_ejercicio varchar(50) not null,
                 tipo_ejercicio varchar(50) not null,
                 repeticion_ejercicio int,
                 duracion_ejercicio int,
    	         primary key (ID_EJERCICIO)
        ) ;

      create table rutina (
        	       	 id_rutina bigint not null auto_increment,
        	         nombre_rutina varchar(50) not null,
                     id_usuario bigint not null,
                     primary key(id_rutina),
		 constraint fk_rutina_usuario foreign key (id_usuario) references usuario (id_usuario)
		 on delete cascade) ;

        create table gif (
             id_multimedia bigint not null auto_increment,
             nombre_multimedia varchar(50) not null,
             multimedia longblob,
             ID_EJERCICIO bigint not null,
             primary key (id_multimedia),
            constraint fk_gif_ejercicio	foreign key (ID_EJERCICIO) references ejercicio (ID_EJERCICIO) on update cascade
      ) ;

          
          create table rutina_ejercicio (
         id_rutina bigint not null,
	     ID_EJERCICIO bigint not null,
	     
	     primary key (
	      id_rutina,
	      ID_EJERCICIO
	     ),
		 constraint fk_rutina_ejercicio_1 foreign key (id_rutina) references rutina (id_rutina) on delete cascade,
		 constraint fk_rutina_ejercicio_2 foreign key (ID_EJERCICIO) references ejercicio (ID_EJERCICIO)
	);
	
		create table usuario_video (
		     id_usuario bigint not null,
		     id_multimedia bigint,
		     primary key (
		      id_usuario,
		      id_multimedia
		     ),
			 constraint fk_usuario_video_1 foreign key (id_usuario) references usuario (id_usuario) on delete cascade,
			 constraint fk_usuario_video_2 foreign key (id_multimedia) references video (id_multimedia)
		);
