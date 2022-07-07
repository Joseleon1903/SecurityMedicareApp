CREATE TABLE CIUDADANO
(
  CIUDADANO_ID                  SERIAL PRIMARY KEY,
  CEDULA                        VARCHAR(11),
  NSS                           INT    NOT NULL,
  NOMBRE                        VARCHAR(50) NOT NULL,
  PRIMER_APELLIDO               VARCHAR(40) NOT NULL,
  SEGUNDO_APELLIDO              VARCHAR(40),
  MUNICIPIO_ID                  INT,
  NACIONALIDAD_ID               INT,
  EXTRANJERO                    BOOL  NOT NULL,
  FECHA_NACIMIENTO              DATE         NOT NULL,
  GENERO                        VARCHAR(1)  NOT NULL,
  ESTADO                        VARCHAR(2)  NOT NULL
);

COMMENT ON TABLE CIUDADANO IS 'Repositorio que almacena los ciudadanos asociados al sistema.';

COMMENT ON COLUMN CIUDADANO.CIUDADANO_ID  IS 'Codigo que identifica el ciudadano';
COMMENT ON COLUMN CIUDADANO.CEDULA  IS 'Cedula del ciudadano';
COMMENT ON COLUMN CIUDADANO.NSS  IS 'Nmero de Segurida Social del ciudadano';
COMMENT ON COLUMN CIUDADANO.NOMBRE  IS 'Nombre del ciudadano';
COMMENT ON COLUMN CIUDADANO.PRIMER_APELLIDO  IS 'Primer Apellido del Ciudadano';
COMMENT ON COLUMN CIUDADANO.SEGUNDO_APELLIDO  IS 'Segundo Apellido del Ciudadano';
COMMENT ON COLUMN CIUDADANO.MUNICIPIO_ID  IS 'Codigo con el que se identifica el municipio del ciudadano';
COMMENT ON COLUMN CIUDADANO.NACIONALIDAD_ID  IS 'Codigo que identifica la nacionalidad del ciudadano';
COMMENT ON COLUMN CIUDADANO.EXTRANJERO IS 'Indica si el ciudadano tiene una codula que cumple con el formato establecido para ciudadanos extranjeros o no. Posibles valores 0=No, 1=Si';
COMMENT ON COLUMN CIUDADANO.FECHA_NACIMIENTO  IS 'Fecha de nacimiento del ciudadano';
COMMENT ON COLUMN CIUDADANO.GENERO  IS 'Gonero del Ciudadano. Posibles valores: M = Masculino, F = Femenino';
COMMENT ON COLUMN CIUDADANO.ESTADO IS 'Estado del ciudadano. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE CIUDADANO ADD CONSTRAINT CIUDADANO_MUNICIPIO_FK FOREIGN KEY (MUNICIPIO_ID) REFERENCES MUNICIPIO(MUNICIPIO_ID);
ALTER TABLE CIUDADANO ADD CONSTRAINT CIUDADANO_NACIONALIDAD_FK FOREIGN KEY (NACIONALIDAD_ID) REFERENCES NACIONALIDAD(NACIONALIDAD_ID);
ALTER TABLE CIUDADANO ADD CONSTRAINT CIUDADANO_GENERO_CK CHECK (GENERO IN ('F', 'M'));
ALTER TABLE CIUDADANO ADD CONSTRAINT CIUDADANO_ESTADO_CK CHECK (ESTADO IN ('AC', 'IN'));