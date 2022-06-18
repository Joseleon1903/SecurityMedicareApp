CREATE TABLE TIPO_ENTIDAD
(
  TIPO_ENTIDAD_ID        NUMBER(3)     NOT NULL,
  DESCRIPCION            VARCHAR2(150) NOT NULL,
  SIGLA                  VARCHAR2(10)  NOT NULL,
  LDAP_ORGANIZATION_UNIT VARCHAR2(50),
  SEGURO_ID              NUMBER(2),
  ESTADO                 VARCHAR2(2)   NOT NULL
)
TABLESPACE SIGMA_DATA;

COMMENT ON TABLE TIPO_ENTIDAD IS 'Catalogo de tipos de entidades asociadas al Sistema';

COMMENT ON COLUMN TIPO_ENTIDAD.TIPO_ENTIDAD_ID IS 'Codigo que identifica el tipo de entidad';
COMMENT ON COLUMN TIPO_ENTIDAD.DESCRIPCION IS 'Descripcion del tipo de entidad';
COMMENT ON COLUMN TIPO_ENTIDAD.SIGLA IS 'Siglas con que se identifica la entidad';
COMMENT ON COLUMN TIPO_ENTIDAD.LDAP_ORGANIZATION_UNIT IS 'Codigo que identifica la rama a la que pertenece la entidad en LDAP';
COMMENT ON COLUMN TIPO_ENTIDAD.SEGURO_ID IS 'Codigo que identifica el seguro';
COMMENT ON COLUMN TIPO_ENTIDAD.ESTADO IS 'Estado del tipo de entidad. Posibles valores: AC = Activo, IN = Inactivo';

CREATE UNIQUE INDEX TIPO_ENTIDAD_IDX ON TIPO_ENTIDAD(TIPO_ENTIDAD_ID) TABLESPACE SIGMA_INDEX;

ALTER TABLE TIPO_ENTIDAD ADD CONSTRAINT TIPO_ENTIDAD_PK PRIMARY KEY (TIPO_ENTIDAD_ID);
ALTER TABLE TIPO_ENTIDAD ADD CONSTRAINT TIPO_ENTIDAD_SEGURO_FK FOREIGN KEY (SEGURO_ID) REFERENCES SEGURO(SEGURO_ID);
ALTER TABLE TIPO_ENTIDAD ADD CONSTRAINT TIPO_ENTIDAD_ESTADO_CK CHECK (ESTADO in ('AC', 'IN'));

GRANT REFERENCES ON TIPO_ENTIDAD TO PUBLIC;
