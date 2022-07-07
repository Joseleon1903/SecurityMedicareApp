CREATE TABLE USUARIO
(
  USUARIO_ID                    SERIAL PRIMARY KEY,
  CODIGO                        VARCHAR(30)  NOT NULL,
  CONTACTO_ID                   INT     NOT NULL,
  TIPO_USUARIO_ID               INT     NOT NULL,
  LLAVE_ENCRIPTACION_CLAVE      VARCHAR(150),
  FECHA_ULTIMO_CAMBIO           DATE,
  ESTADO                        VARCHAR(2)   NOT NULL
);

COMMENT ON TABLE USUARIO IS 'Catálogo de usuarios del sistema';

COMMENT ON COLUMN USUARIO.USUARIO_ID IS 'Número secuencial que identifica el usuario';
COMMENT ON COLUMN USUARIO.CODIGO IS 'Código del usuario';
COMMENT ON COLUMN USUARIO.CONTACTO_ID IS 'Código que identifica al contacto asociado al usuario';
COMMENT ON COLUMN USUARIO.TIPO_USUARIO_ID IS 'Código único que identifica el tipo de usuario';
COMMENT ON COLUMN USUARIO.LLAVE_ENCRIPTACION_CLAVE IS 'Caracteres utlizado para la encriptacion de la clave del usuario';
COMMENT ON COLUMN USUARIO.FECHA_ULTIMO_CAMBIO IS 'Fecha ultimo cambio en el registro';
COMMENT ON COLUMN USUARIO.ESTADO IS 'Estado del usuario. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_CONTACTO_FK FOREIGN KEY (CONTACTO_ID) REFERENCES CONTACTO(CONTACTO_ID);
ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_TIPO_USUARIO_FK FOREIGN KEY (TIPO_USUARIO_ID) REFERENCES TIPO_USUARIO(TIPO_USUARIO_ID);
ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_ESTADO_CK CHECK (ESTADO IN ('AC', 'IN'));