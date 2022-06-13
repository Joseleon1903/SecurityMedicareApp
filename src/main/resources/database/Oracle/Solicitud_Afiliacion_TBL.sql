CREATE TABLE SOLICITUD_AFILIACION
(
  SOLICITUD_ID                  NUMBER(10)   NOT NULL,
  SERVICIO_ID                   NUMBER(6)    NOT NULL,
  LOTE_ID                       NUMBER(10),
  ENTIDAD_ID                    NUMBER(5)    NOT NULL,
  SEGURO_ID                     NUMBER(2)    NOT NULL,
  REGIMEN_ID                    NUMBER(2)    NOT NULL,
  TIPO_AFILIADO                 VARCHAR2(1)  NOT NULL,
  TIPO_IDENTIFICACION_ID        NUMBER(3)    NOT NULL,
  NOMBRE                        VARCHAR2(50) NOT NULL,
  PRIMER_APELLIDO               VARCHAR2(40) NOT NULL,
  CODIGO_MUNICIPIO              VARCHAR2(4),
  CODIGO_PROVINCIA              VARCHAR2(3),
  CIUDADANO_EXTRANJERO          NUMBER(1)    DEFAULT 0,
  AUTOMATICA                    NUMBER(1)    DEFAULT 0 NOT NULL,
  INSTITUCION_PENSIONADO_ID     NUMBER(3),
  CLAVE_INSTITUCION_PENSIONADO  NUMBER(3),
  ESTADO                        VARCHAR2(2)  NOT NULL,
  FECHA_RECEPCION               DATE         NOT NULL,
  MUNICIPIO_ID                  NUMBER(4),
  CIUDADANO_ID                  NUMBER(10),
  ULTIMA_AFILIACION_ID          NUMBER(10),
  FECHA_ULTIMO_CAMBIO           DATE         DEFAULT SYSDATE NOT NULL
)
TABLESPACE SIGMA_DATA;

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
COMMENT ON COLUMN SOLICITUD_AFILIACION.CODIGO_MUNICIPIO IS 'Codigo conocido por el negocio con el que se registra el municipio en el catalogo de municipio';
COMMENT ON COLUMN SOLICITUD_AFILIACION.CODIGO_PROVINCIA IS 'Codigo con el que se identifica la provincia en el catalogo de provincia';
COMMENT ON COLUMN SOLICITUD_AFILIACION.CIUDADANO_EXTRANJERO IS '  Indica si el ciudadano que se esta afiliando tiene una cÃ©dula que cumple con el formato establecido para ciudadanos extranjeros o no';
COMMENT ON COLUMN SOLICITUD_AFILIACION.AUTOMATICA IS '  Indica si la Solicitud de afiliacion se realizo automanticamente o no';
COMMENT ON COLUMN SOLICITUD_AFILIACION.INSTITUCION_PENSIONADO_ID IS 'Codigo que identifica la institucion cuando la Solicitud de afiliacion corresponde a un pensionado';
COMMENT ON COLUMN SOLICITUD_AFILIACION.CLAVE_INSTITUCION_PENSIONADO IS 'Codigo enviado por la entidad que identifica la institucion cuando la Solicitud de afiliacion corresponde a un pensionado';
COMMENT ON COLUMN SOLICITUD_AFILIACION.ESTADO IS 'Codigo con el que se identifica el estado de la solicitud de afiliacion. Posibles valores: OK = Aceptada, PE = Pendiente, RE = Rechazada';
COMMENT ON COLUMN SOLICITUD_AFILIACION.FECHA_RECEPCION IS 'Fecha en que se recibe la solicitud en el sistema';
COMMENT ON COLUMN SOLICITUD_AFILIACION.MUNICIPIO_ID IS 'ID con el que se identifica el municipio en el catalogo de municipios.';
COMMENT ON COLUMN SOLICITUD_AFILIACION.ESTADO_POSTERIOR_CARGA_DOC IS 'Estado en que debe quedar la solicitud despuÃ©s de la carga de la imagen';
COMMENT ON COLUMN SOLICITUD_AFILIACION.MOTIVO_POSTERIOR_CARGA_DOC_ID IS 'Motivo del estado en que debe quedar la solicitud despuÃ©s de la carga de la imagen';
COMMENT ON COLUMN SOLICITUD_AFILIACION.CIUDADANO_ID IS 'Codigo con el que se identifica el afiliado en el maestro de ciudadanos';
COMMENT ON COLUMN SOLICITUD_AFILIACION.ULTIMA_AFILIACION_ID IS 'ID de la ultima afiliacion asociada a la solicitud';
COMMENT ON COLUMN SOLICITUD_AFILIACION.FECHA_ULTIMO_CAMBIO IS 'Fecha de ultimo cambio en el registro. Esta columna sera actualizada automaticamente cada vez que sea creado o actualizado el registro en cuestion, directamente en esta tabla, o actualizado en alguna de sus tablas hijas:  SOLICITUD_AFILIACION_TITULAR,SOLICITUD_AFI_DEPENDIENTE';

CREATE UNIQUE INDEX SOLICITUD_AFILIACION_IDX ON SOLICITUD_AFILIACION(SOLICITUD_ID) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOLICITUD_AFILIACION_LOTE_IDX ON SOLICITUD_AFILIACION(LOTE_ID) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOL_AFILIACION_ENTIDAD_IDX ON SOLICITUD_AFILIACION(ENTIDAD_ID) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOL_AFILIACION_ESTADO_IDX ON SOLICITUD_AFILIACION(ESTADO) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOL_AFILIACION_SERVICIO_IDX ON SOLICITUD_AFILIACION(SERVICIO_ID) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOL_AFI_TIPO_AFILIADO_IDX ON SOLICITUD_AFILIACION(TIPO_AFILIADO) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOL_AFI_TIP_IDENTIFICACION_IDX ON SOLICITUD_AFILIACION(TIPO_IDENTIFICACION_ID) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOL_AFILIACION_CIUDADANO_IDX ON SOLICITUD_AFILIACION(CIUDADANO_ID) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOL_AFI_ULTIMA_AFILIACION_IDX ON SOLICITUD_AFILIACION(ULTIMA_AFILIACION_ID) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOL_AFI_INSTT_PEN_IDX ON SOLICITUD_AFILIACION(INSTITUCION_PENSIONADO_ID) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOL_AFI_MOTIVO_POST_CARGA_IDX ON SOLICITUD_AFILIACION(MOTIVO_POSTERIOR_CARGA_DOC_ID) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOL_AFI_MUNICIPIO_IDX ON SOLICITUD_AFILIACION(MUNICIPIO_ID) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOL_AFI_SEGURO_IDX ON SOLICITUD_AFILIACION(SEGURO_ID) TABLESPACE SIGMA_INDEX;
CREATE INDEX SOL_AFI_REGIMEN_IDX ON SOLICITUD_AFILIACION(REGIMEN_ID) TABLESPACE SIGMA_INDEX;

ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOLICITUD_AFILIACION_PK PRIMARY KEY (SOLICITUD_ID) USING INDEX SOLICITUD_AFILIACION_IDX;
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_SERVICIO_FK FOREIGN KEY (SERVICIO_ID) REFERENCES SERVICIO_SISTEMA(SERVICIO_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_LOTE_FK FOREIGN KEY (LOTE_ID) REFERENCES LOTE(LOTE_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_ENTIDAD_FK FOREIGN KEY (ENTIDAD_ID) REFERENCES ENTIDAD(ENTIDAD_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOLICITUD_AFILIACION_SEGURO_FK FOREIGN KEY (SEGURO_ID) REFERENCES SEGURO(SEGURO_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_REGIMEN_FK FOREIGN KEY (REGIMEN_ID) REFERENCES REGIMEN(REGIMEN_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_TIPO_AFI_CK CHECK (TIPO_AFILIADO in ('D', 'T'));
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFI_TIPO_IDENTIFICACION_FK FOREIGN KEY (TIPO_IDENTIFICACION_ID) REFERENCES TIPO_IDENTIFICACION(TIPO_IDENTIFICACION_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFI_CIU_EXTRANJERO_CK CHECK (CIUDADANO_EXTRANJERO IN (0, 1));
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_AUTOMATICA_CK CHECK (AUTOMATICA IN (0, 1));
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_INSTT_PEN_FK FOREIGN KEY (INSTITUCION_PENSIONADO_ID) REFERENCES INSTITUCION_PENSIONADO(INSTITUCION_PENSIONADO_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOLICITUD_AFILIACION_ESTADO_CK CHECK (ESTADO in ('OK', 'PE', 'RE'));
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_MUNICIPIO_FK FOREIGN KEY (MUNICIPIO_ID) REFERENCES MUNICIPIO(MUNICIPIO_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFI_ST_POST_CARGA_DOC_CK CHECK (ESTADO_POSTERIOR_CARGA_DOC IN ('OK', 'PE'));
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_MOT_ESTADO_FK FOREIGN KEY (MOTIVO_POSTERIOR_CARGA_DOC_ID) REFERENCES MOTIVO_ESTADO(MOTIVO_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_CIUDADANO_FK FOREIGN KEY (CIUDADANO_ID) REFERENCES CIUDADANO(CIUDADANO_ID);
ALTER TABLE SOLICITUD_AFILIACION ADD CONSTRAINT SOL_AFILIACION_ULTIMA_AFI_FK FOREIGN KEY (ULTIMA_AFILIACION_ID) REFERENCES AFILIACION(AFILIACION_ID);