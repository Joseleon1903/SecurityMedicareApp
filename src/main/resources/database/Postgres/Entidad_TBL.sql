CREATE TABLE ENTIDAD
(
  ENTIDAD_ID                   	SERIAL PRIMARY KEY,
  TIPO_ENTIDAD_ID              	INT     NOT NULL,
  CLAVE_ENTIDAD                	INT     NOT NULL,
  SIGLA                        	VARCHAR(10),
  DESCRIPCION                  	VARCHAR(150) NOT NULL,
  REGIMEN_ID                   	INT,
  PARTICIPA_AFILIACION_AUT     	INT     NOT NULL,
  RNC                          	VARCHAR(9),
  ENTIDAD_SUPERVISORA_ID       	INT,
  ESTADO                       	VARCHAR(2)   NOT NULL,
  MUNICIPIO_ID                 	INT
);


COMMENT ON TABLE ENTIDAD IS 'Catalogo de Entidades asociadas al Sistema';

COMMENT ON COLUMN ENTIDAD.ENTIDAD_ID IS 'Codigo que identifica la Entidad en el sistema';
COMMENT ON COLUMN ENTIDAD.TIPO_ENTIDAD_ID IS 'Codigo que identifica el Tipo de Entidad a la que pertenece la entidad';
COMMENT ON COLUMN ENTIDAD.CLAVE_ENTIDAD IS 'Codigo que identifica la Entidad en el SDSS';
COMMENT ON COLUMN ENTIDAD.SIGLA IS 'Siglas de la Entidad';
COMMENT ON COLUMN ENTIDAD.DESCRIPCION IS 'Descripcion de la Entidad';
COMMENT ON COLUMN ENTIDAD.REGIMEN_ID IS 'Codigo del regimen';
COMMENT ON COLUMN ENTIDAD.PARTICIPA_AFILIACION_AUT IS 'Indicador que determina si la entidad participa en el proceso de afiliacion automatica. Posibles valores: 0 = No, 1 = Si';
COMMENT ON COLUMN ENTIDAD.RNC IS 'RNC que identifica la entidad';
COMMENT ON COLUMN ENTIDAD.ENTIDAD_SUPERVISORA_ID IS 'Codigo que identifica la Entidad supervisora en el sistema';
COMMENT ON COLUMN ENTIDAD.ESTADO IS 'Estado de la Entidad. Posibles valores: AC = Activo, IN = Inactivo';
COMMENT ON COLUMN ENTIDAD.MUNICIPIO_ID IS 'Codigo con el que se identifica el municipio en el catalogo de municipio';

ALTER TABLE ENTIDAD ADD CONSTRAINT ENTIDAD_TIPO_ENTIDAD_FK FOREIGN KEY (TIPO_ENTIDAD_ID) REFERENCES TIPO_ENTIDAD(TIPO_ENTIDAD_ID);
ALTER TABLE ENTIDAD ADD CONSTRAINT ESTADO_ENTIDAD_CK CHECK (ESTADO in ('AC', 'IN'));