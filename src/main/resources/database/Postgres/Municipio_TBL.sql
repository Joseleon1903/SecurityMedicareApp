CREATE TABLE MUNICIPIO
(
  MUNICIPIO_ID     SERIAL PRIMARY KEY,
  DESCRIPCION      VARCHAR(150) NOT NULL,
  CODIGO_MUNICIPIO VARCHAR(4)   NOT NULL,
  PROVINCIA_ID     INT     NOT NULL,
  ESTADO           VARCHAR(2)   NOT NULL
);

COMMENT ON TABLE MUNICIPIO IS 'Repositorio que aloja los municipios en los que estan divididas las localidades de salud';

COMMENT ON COLUMN MUNICIPIO.MUNICIPIO_ID IS 'Codigo con el que se identifica el municipio en el catalogo de municipio';
COMMENT ON COLUMN MUNICIPIO.DESCRIPCION IS 'Nombre del municipio registrado';
COMMENT ON COLUMN MUNICIPIO.CODIGO_MUNICIPIO IS 'Codigo conocido por el negocio con el que se registra el municipio en el catalogo de municipio';
COMMENT ON COLUMN MUNICIPIO.PROVINCIA_ID IS 'Codigo con el que se identifica la provincia en el catalogo de provincias';
COMMENT ON COLUMN MUNICIPIO.ESTADO IS 'Estado del municipio. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE MUNICIPIO ADD CONSTRAINT MUNICIPIO_ESTADO_CK CHECK (ESTADO in ('AC', 'IN'));