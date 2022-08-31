CREATE TABLE CONTACTO
(
  CONTACTO_ID                  SERIAL PRIMARY KEY,
  DESCRIPCION                  VARCHAR(150),
  CORREO_PRIMARIO           VARCHAR(128) NOT NULL,
  CORREO_ALTERNO               VARCHAR(128),
  POSICION                     VARCHAR(60),
  FECHA_CREACION               DATE          NOT NULL,
  FECHA_ULTIMO_CAMBIO          DATE,
  ESTADO                       VARCHAR(2)   NOT NULL
);

COMMENT ON TABLE CONTACTO IS 'Repositorio que almacena los contactos del sistema.';

COMMENT ON COLUMN CONTACTO.CONTACTO_ID IS 'Código que identifica el contacto';
COMMENT ON COLUMN CONTACTO.DESCRIPCION IS 'Descripción del contacto aplicable cuando el tipo de persona sea 3-Notificación';
COMMENT ON COLUMN CONTACTO.CORREO_PRIMARIO IS 'correo principal del usuario';
COMMENT ON COLUMN CONTACTO.CORREO_ALTERNO IS 'Correo alterno del contacto';
COMMENT ON COLUMN CONTACTO.POSICION IS 'Posición del contacto';
COMMENT ON COLUMN CONTACTO.FECHA_CREACION IS 'Fecha en la que se creó el contacto';
COMMENT ON COLUMN CONTACTO.FECHA_ULTIMO_CAMBIO IS 'Fecha en la que se realizó el último cambio';
COMMENT ON COLUMN CONTACTO.ESTADO IS 'Estado en el que se encuentra el contacto. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE CONTACTO ADD CONSTRAINT CONTACTO_ESTADO_CK CHECK (ESTADO IN ('AC', 'IN'));