CREATE TABLE SOLICITUD_AFILIACION
(
  SOLICITUD_ID                  SERIAL PRIMARY KEY,
  SERVICIO_ID                   INT    NOT NULL,
  LOTE_ID                       INT,
  ENTIDAD_ID                    INT    NOT NULL,
  SEGURO_ID                     INT    NOT NULL,
  REGIMEN_ID                    INT    NOT NULL,
  TIPO_AFILIADO                 VARCHAR(1)  NOT NULL,
  TIPO_IDENTIFICACION_ID        INT    NOT NULL,
  NOMBRE                        VARCHAR(50) NOT NULL,
  PRIMER_APELLIDO               VARCHAR(40) NOT NULL,
  AUTOMATICA                    bool NOT NULL,
  INSTITUCION_PENSIONADO_ID     INT,
  CLAVE_INSTITUCION_PENSIONADO  INT,
  ESTADO                        VARCHAR(2)  NOT NULL,
  FECHA_RECEPCION               DATE         NOT NULL,
  MUNICIPIO_ID                  INT,
  CIUDADANO_ID                  INT,
  FECHA_ULTIMO_CAMBIO           DATE        NOT NULL
);

COMMENT ON TABLE SOLICITUD_AFILIACION IS 'Repositorio que aloja los datos generales de las solicitudes de afiliacion realizadas en el sistema';

COMMENT ON COLUMN SOLICITUD_AFILIACION.SOLICITUD_ID IS 'Codigo que identifica la solicitud de afiliacion realizada en el sistema';
COMMENT ON COLUMN SOLICITUD_AFILIACION.SERVICIO_ID IS 'Codigo que identifica el Servicio del Sistema';
COMMENT ON COLUMN SOLICITUD_AFILIACION.LOTE_ID  IS 'Codigo que identifica el lote';
COMMENT ON COLUMN SOLICITUD_AFILIACION.ENTIDAD_ID  IS 'Codigo de la entidad que gestiona la afiliacion';
COMMENT ON COLUMN SOLICITUD_AFILIACION.SEGURO_ID IS 'ID del Seguro al que pertence la entidad asociada a la solicitud';
COMMENT ON COLUMN SOLICITUD_AFILIACION.REGIMEN_ID IS 'ID del Regimen al que pertenece la entidad asociada a la solicitud.';
COMMENT ON COLUMN SOLICITUD_AFILIACION.TIPO_AFILIADO  IS 'Tipo de afiliado. Posibles valores: T = Titular, D = Dependiente';
COMMENT ON COLUMN SOLICITUD_AFILIACION.TIPO_IDENTIFICACION_ID  IS 'Codigo del tipo de la identifiacion enviada en la solicitud';
COMMENT ON COLUMN SOLICITUD_AFILIACION.NOMBRE IS 'Nombre del ciudadano que se esta afiliando';
COMMENT ON COLUMN SOLICITUD_AFILIACION.PRIMER_APELLIDO IS 'Apellido del ciudadano que se esta afiliando';
COMMENT ON COLUMN SOLICITUD_AFILIACION.AUTOMATICA IS '  Indica si la Solicitud de afiliacion se realizo automanticamente o no';
COMMENT ON COLUMN SOLICITUD_AFILIACION.INSTITUCION_PENSIONADO_ID IS 'Codigo que identifica la institucion cuando la Solicitud de afiliacion corresponde a un pensionado';
COMMENT ON COLUMN SOLICITUD_AFILIACION.CLAVE_INSTITUCION_PENSIONADO IS 'Codigo enviado por la entidad que identifica la institucion cuando la Solicitud de afiliacion corresponde a un pensionado';
COMMENT ON COLUMN SOLICITUD_AFILIACION.ESTADO IS 'Codigo con el que se identifica el estado de la solicitud de afiliacion. Posibles valores: OK = Aceptada, PE = Pendiente, RE = Rechazada';
COMMENT ON COLUMN SOLICITUD_AFILIACION.MUNICIPIO_ID IS 'ID con el que se identifica el municipio en el catalogo de municipios.';
COMMENT ON COLUMN SOLICITUD_AFILIACION.CIUDADANO_ID IS 'Codigo con el que se identifica el afiliado en el maestro de ciudadanos';
COMMENT ON COLUMN SOLICITUD_AFILIACION.FECHA_ULTIMO_CAMBIO IS 'Fecha de ultimo cambio en el registro. Esta columna sera actualizada automaticamente cada vez que sea creado o actualizado el registro en cuestion, directamente en esta tabla, o actualizado en alguna de sus tablas hijas:  SOLICITUD_AFILIACION_TITULAR,SOLICITUD_AFI_DEPENDIENTE';

ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_ENTIDAD_FK FOREIGN KEY (ENTIDAD_ID) REFERENCES ENTIDAD(ENTIDAD_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOLICITUD_AFILIACION_SEGURO_FK FOREIGN KEY (SEGURO_ID) REFERENCES SEGURO(SEGURO_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_TIPO_AFI_CK CHECK (TIPO_AFILIADO in ('D', 'T'));
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_INSTT_PEN_FK FOREIGN KEY (INSTITUCION_PENSIONADO_ID) REFERENCES INSTITUCION_PENSIONADO(INSTITUCION_PENSIONADO_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOLICITUD_AFILIACION_ESTADO_CK CHECK (ESTADO in ('OK', 'PE', 'RE'));
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_MUNICIPIO_FK FOREIGN KEY (MUNICIPIO_ID) REFERENCES MUNICIPIO(MUNICIPIO_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_CIUDADANO_FK FOREIGN KEY (CIUDADANO_ID) REFERENCES CIUDADANO(CIUDADANO_ID);