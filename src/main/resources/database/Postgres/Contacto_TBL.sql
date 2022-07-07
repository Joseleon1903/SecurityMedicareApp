CREATE TABLE CONTACTO
(
  CONTACTO_ID                  SERIAL PRIMARY KEY,
  TIPO_PERSONA                 INT     NOT NULL,
  ENTIDAD_ID                   INT     NOT NULL,
  CIUDADANO_ID                 INT,
  DESCRIPCION                  VARCHAR(150),
  CORREO_CORPORATIVO           VARCHAR(128) NOT NULL,
  CORREO_ALTERNO               VARCHAR(128),
  POSICION                     VARCHAR(60),
  FECHA_CREACION               DATE          NOT NULL,
  FECHA_ULTIMO_CAMBIO          DATE,
  TIENE_HIJOS                  bool     DEFAULT false NOT NULL,
  ESTADO                       VARCHAR(2)   NOT NULL
);

COMMENT ON TABLE CONTACTO IS 'Repositorio que almacena los contactos del sistema.';

COMMENT ON COLUMN CONTACTO.CONTACTO_ID IS 'Código que identifica el contacto';
COMMENT ON COLUMN CONTACTO.TIPO_PERSONA IS 'Código que identifica el tipo de persona asociado al contacto. Posibles valores: 1=Física, 2=Moral, 3=Notificación.';
COMMENT ON COLUMN CONTACTO.ENTIDAD_ID IS 'Entidad a la que pertenece el contacto';
COMMENT ON COLUMN CONTACTO.CIUDADANO_ID IS 'Código del ciudadano asociado a la cuenta';
COMMENT ON COLUMN CONTACTO.DESCRIPCION IS 'Descripción del contacto aplicable cuando el tipo de persona sea 3-Notificación';
COMMENT ON COLUMN CONTACTO.CORREO_CORPORATIVO IS 'correo corporativo del usuario';
COMMENT ON COLUMN CONTACTO.CORREO_ALTERNO IS 'Correo alterno del contacto';
COMMENT ON COLUMN CONTACTO.POSICION IS 'Posición del contacto';
COMMENT ON COLUMN CONTACTO.FECHA_CREACION IS 'Fecha en la que se creó el contacto';
COMMENT ON COLUMN CONTACTO.FECHA_ULTIMO_CAMBIO IS 'Fecha en la que se realizó el último cambio';
COMMENT ON COLUMN CONTACTO.TIENE_HIJOS IS 'Indicador que dice si el contacto tiene hijos o no. Posibles valores 0=No, 1=Si';
COMMENT ON COLUMN CONTACTO.ESTADO IS 'Estado en el que se encuentra el contacto. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE CONTACTO ADD CONSTRAINT CONTACTO_TIPO_PERSONA_CK CHECK (TIPO_PERSONA IN (1, 2, 3));
ALTER TABLE CONTACTO ADD CONSTRAINT CONTACTO_ENTIDAD_FK FOREIGN KEY (ENTIDAD_ID) REFERENCES ENTIDAD(ENTIDAD_ID);
ALTER TABLE CONTACTO ADD CONSTRAINT CONTACTO_CIUDADANO_FK FOREIGN KEY (CIUDADANO_ID) REFERENCES CIUDADANO(CIUDADANO_ID);

ALTER TABLE CONTACTO ADD CONSTRAINT CONTACTO_ESTADO_CK CHECK (ESTADO IN ('AC', 'IN'));