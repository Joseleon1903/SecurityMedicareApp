CREATE TABLE SEGURO
(
  SEGURO_ID              INTEGER PRIMARY KEY,
  DESCRIPCION            TEXT NOT NULL,
  CODIGO_SEGURO_CONTABLE INTEGER,
  SEGURO_PADRE_ID        INTEGER,
  ESTADO                 TEXT   NOT NULL
);

COMMENT ON TABLE SEGURO IS 'Catálogo de Seguros del Sistema';

COMMENT ON COLUMN SEGURO.SEGURO_ID IS 'Código que identifica el Seguro';
COMMENT ON COLUMN SEGURO.DESCRIPCION IS 'Descripción del Seguro';
COMMENT ON COLUMN SEGURO.CODIGO_SEGURO_CONTABLE IS 'Código que identifica el Seguro para las Entradas Contables';
COMMENT ON COLUMN SEGURO.SEGURO_PADRE_ID IS 'Código que identifica el Seguro';
COMMENT ON COLUMN SEGURO.ESTADO IS 'Estado del Seguro. Posibles valores: AC = Activo, IN = Inactivo';