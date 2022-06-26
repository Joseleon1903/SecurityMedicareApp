CREATE TABLE MOTIVO_ESTADO
(
  MOTIVO_ID                     SERIAL PRIMARY KEY,
  DESCRIPCION                   VARCHAR(150) NOT NULL,
  ESTADO                        VARCHAR(2)   NOT NULL
);

COMMENT ON TABLE MOTIVO_ESTADO IS 'Catalogo de los motivos de las solicitudes';

COMMENT ON COLUMN MOTIVO_ESTADO.MOTIVO_ID IS 'Codigo con el que se identifica el motivo del estado';
COMMENT ON COLUMN MOTIVO_ESTADO.DESCRIPCION IS 'Descripcion del motivo';
COMMENT ON COLUMN MOTIVO_ESTADO.ESTADO  IS 'Estado del codigo de motivo. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE MOTIVO_ESTADO ADD CONSTRAINT MOTIVO_ESTADO_ESTADO_CK CHECK (ESTADO IN ('AC', 'IN'));