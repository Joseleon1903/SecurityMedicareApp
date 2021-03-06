CREATE TABLE TIPO_ENTIDAD
(
  TIPO_ENTIDAD_ID        SERIAL PRIMARY KEY,
  DESCRIPCION            VARCHAR(150) NOT NULL,
  SEGURO_ID              INT ,
  ESTADO                 VARCHAR(2)   NOT NULL
);

COMMENT ON TABLE TIPO_ENTIDAD IS 'Catalogo de tipos de entidades asociadas al Sistema';

COMMENT ON COLUMN TIPO_ENTIDAD.TIPO_ENTIDAD_ID IS 'Codigo que identifica el tipo de entidad';
COMMENT ON COLUMN TIPO_ENTIDAD.DESCRIPCION IS 'Descripcion del tipo de entidad';
COMMENT ON COLUMN TIPO_ENTIDAD.SEGURO_ID IS 'Codigo que identifica el seguro';
COMMENT ON COLUMN TIPO_ENTIDAD.ESTADO IS 'Estado del tipo de entidad. Posibles valores: AC = Activo, IN = Inactivo';


ALTER TABLE TIPO_ENTIDAD ADD CONSTRAINT TIPO_ENTIDAD_SEGURO_FK FOREIGN KEY (SEGURO_ID) REFERENCES SEGURO(SEGURO_ID);
ALTER TABLE TIPO_ENTIDAD ADD CONSTRAINT TIPO_ENTIDAD_ESTADO_CK CHECK (ESTADO in ('AC', 'IN'));