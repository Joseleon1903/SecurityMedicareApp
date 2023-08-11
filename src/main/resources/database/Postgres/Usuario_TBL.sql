-- public.usuario definition

-- Drop table

-- DROP TABLE public.usuario;
CREATE TABLE public.usuario (
	usuario_id int8 NOT NULL,
	codigo varchar(255) NULL,
	estado varchar(255) NULL,
	fecha_ultimo_cambio timestamp NULL,
	llave_encriptacion varchar(255) NULL,
	profile_picture varchar(255) NULL,
	contacto_id int8 NULL,
	tipo_usuario_id int8 NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (usuario_id)
);


-- public.usuario foreign keys

ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_CONTACTO_FK FOREIGN KEY (CONTACTO_ID) REFERENCES CONTACTO(CONTACTO_ID);
ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_TIPO_USUARIO_FK FOREIGN KEY (TIPO_USUARIO_ID) REFERENCES TIPO_USUARIO(TIPO_USUARIO_ID);
ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_ESTADO_CK CHECK (ESTADO IN ('AC', 'IN'));