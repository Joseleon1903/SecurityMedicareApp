CREATE TABLE INSTITUCION_PENSIONADO
(
  INSTITUCION_PENSIONADO_ID    SERIAL PRIMARY KEY,
  DESCRIPCION                  VARCHAR(200) NOT NULL,
  ESTADO                       VARCHAR(2)   NOT NULL
);

COMMENT ON TABLE INSTITUCION_PENSIONADO IS 'Repositorio que almacena las instituciones de pensionados.';

COMMENT ON COLUMN INSTITUCION_PENSIONADO.INSTITUCION_PENSIONADO_ID IS 'Código único que identifica la institución de pensionado';
COMMENT ON COLUMN INSTITUCION_PENSIONADO.DESCRIPCION IS 'Descripción de la institución de pensionado';
COMMENT ON COLUMN INSTITUCION_PENSIONADO.ESTADO IS 'Estado de la Institución de Pensionado. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE INSTITUCION_PENSIONADO ADD CONSTRAINT INSTITUCION_PENSIONADO_ST_CK CHECK (ESTADO IN ('AC', 'IN'));