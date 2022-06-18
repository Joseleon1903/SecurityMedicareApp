CREATE TABLE GRADO_CONSANGUINIDAD
(
  GRADO_CONSANGUINIDAD_ID NUMBER(2)    NOT NULL,
  DESCRIPCION             VARCHAR2(40) NOT NULL
)
TABLESPACE SIGMA_DATA;

COMMENT ON TABLE GRADO_CONSANGUINIDAD IS 'Catálogo de GRADO_CONSANGUINIDAD del sistema';

COMMENT ON COLUMN GRADO_CONSANGUINIDAD.GRADO_CONSANGUINIDAD_ID  IS 'Código que identifica el grado de consanguinidad';
COMMENT ON COLUMN GRADO_CONSANGUINIDAD.DESCRIPCION  IS 'Descripción del grado de consanguinidad';

CREATE UNIQUE INDEX GRADO_CONSANGUINIDAD_IDX ON GRADO_CONSANGUINIDAD(GRADO_CONSANGUINIDAD_ID) TABLESPACE SIGMA_INDEX;

ALTER TABLE GRADO_CONSANGUINIDAD ADD CONSTRAINT GRADO_CONSANGUINIDAD_PK PRIMARY KEY (GRADO_CONSANGUINIDAD_ID);
