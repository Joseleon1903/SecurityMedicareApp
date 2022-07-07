CREATE TABLE NACIONALIDAD (
	NACIONALIDAD_ID serial4 NOT NULL,
	DESCRIPCION varchar(255) NOT NULL,
	PAIS_ID varchar(255) NOT NULL,
	ESTADO varchar(10) NULL,
	CONSTRAINT nacionalidad_pkey PRIMARY KEY (nacionalidad_id)
);

COMMENT ON TABLE NACIONALIDAD IS 'Repositorio que aloja las nacionalidades en los que estan divididas las localidades de salud';

COMMENT ON COLUMN NACIONALIDAD.NACIONALIDAD_ID IS 'Codigo con el que se identifica la nacionalidad en el catalogo de municipio';
COMMENT ON COLUMN NACIONALIDAD.DESCRIPCION IS 'Nombre de la nacionalidad registrado';
COMMENT ON COLUMN NACIONALIDAD.PAIS_ID IS 'Codigo que identifica un pais';
COMMENT ON COLUMN NACIONALIDAD.ESTADO IS 'Estado Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE NACIONALIDAD ADD CONSTRAINT NACIONALIDAD_ESTADO_CK CHECK (ESTADO in ('AC', 'IN'));