CREATE TABLE SEGURO
(
  SEGURO_ID              NUMBER(2)     NOT NULL,
  DESCRIPCION            VARCHAR2(150) NOT NULL,
  CODIGO_SEGURO_CONTABLE NUMBER(1),
  SEGURO_PADRE_ID        NUMBER(2),
  ESTADO                 VARCHAR2(2)   NOT NULL
)
TABLESPACE SIGMA_DATA;

COMMENT ON TABLE SEGURO IS 'Catálogo de Seguros del Sistema';

COMMENT ON COLUMN SEGURO.SEGURO_ID IS 'Código que identifica el Seguro';
COMMENT ON COLUMN SEGURO.DESCRIPCION IS 'Descripción del Seguro';
COMMENT ON COLUMN SEGURO.CODIGO_SEGURO_CONTABLE IS 'Código que identifica el Seguro para las Entradas Contables';
COMMENT ON COLUMN SEGURO.SEGURO_PADRE_ID IS 'Código que identifica el Seguro';
COMMENT ON COLUMN SEGURO.ESTADO IS 'Estado del Seguro. Posibles valores: AC = Activo, IN = Inactivo';

CREATE UNIQUE INDEX SEGURO_IDX ON SEGURO(SEGURO_ID) TABLESPACE SIGMA_INDEX;

ALTER TABLE SEGURO ADD CONSTRAINT SEGURO_PK PRIMARY KEY (SEGURO_ID) USING INDEX SEGURO_IDX;
ALTER TABLE SEGURO ADD CONSTRAINT SEGURO_SEGURO_PADRE_FK FOREIGN KEY (SEGURO_PADRE_ID) REFERENCES SEGURO(SEGURO_ID);
ALTER TABLE SEGURO ADD CONSTRAINT SEGURO_ESTADO_CK CHECK (ESTADO in ('AC', 'IN'));
