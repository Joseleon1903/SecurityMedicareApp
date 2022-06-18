CREATE TABLE MOTIVO_ESTADO
(
  MOTIVO_ID                     NUMBER(6)     NOT NULL,
  DESCRIPCION                   VARCHAR2(150) NOT NULL,
  ESTADO                        VARCHAR2(2)   NOT NULL
)
TABLESPACE SIGMA_DATA;

COMMENT ON TABLE MOTIVO_ESTADO IS 'Catalogo de los motivos de las solicitudes';

COMMENT ON COLUMN MOTIVO_ESTADO.MOTIVO_ID IS 'Codigo con el que se identifica el motivo del estado';
COMMENT ON COLUMN MOTIVO_ESTADO.DESCRIPCION IS 'Descripcion del motivo';
COMMENT ON COLUMN MOTIVO_ESTADO.PERMITE_DUPLICIDAD IS 'Indicador de si el motivo puede aparecer en varios registros a la vez. Posibles valores: 0 = No (Valor por defecto), 1 = Si';
COMMENT ON COLUMN MOTIVO_ESTADO.SERVICIO_PRINCIPAL_PROCESA_ID IS 'Codigo del servicio que pricipalmente genera el motivo del estado';
COMMENT ON COLUMN MOTIVO_ESTADO.ESTADO  IS 'Estado del codigo de motivo. Posibles valores: AC = Activo, IN = Inactivo';

CREATE UNIQUE INDEX MOTIVO_ESTADO_IDX ON MOTIVO_ESTADO(MOTIVO_ID) TABLESPACE SIGMA_INDEX;

ALTER TABLE MOTIVO_ESTADO ADD CONSTRAINT MOTIVO_ESTADO_PK PRIMARY KEY (MOTIVO_ID);
ALTER TABLE MOTIVO_ESTADO ADD CONSTRAINT MOTIVO_ESTADO_PERMITE_DUP_CK CHECK (PERMITE_DUPLICIDAD IN (0, 1));
ALTER TABLE MOTIVO_ESTADO ADD CONSTRAINT MOTIVO_ESTADO_SERVICIO_SIS_FK FOREIGN KEY (SERVICIO_PRINCIPAL_PROCESA_ID) REFERENCES SERVICIO_SISTEMA(SERVICIO_ID);
ALTER TABLE MOTIVO_ESTADO ADD CONSTRAINT MOTIVO_ESTADO_ESTADO_CK CHECK (ESTADO IN ('AC', 'IN'));
