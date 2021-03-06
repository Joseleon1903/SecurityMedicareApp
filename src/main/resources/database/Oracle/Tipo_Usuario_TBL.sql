CREATE TABLE TIPO_USUARIO
(
  TIPO_USUARIO_ID  NUMBER(3)     NOT NULL,
  DESCRIPCION      VARCHAR2(150) NOT NULL,
  TIPO_PERSONA     NUMBER(1)     NOT NULL,
  ESTADO           VARCHAR2(2)   NOT NULL
)
;

COMMENT ON TABLE TIPO_USUARIO IS 'Código único que identifica el tipo de contacto';

COMMENT ON COLUMN TIPO_USUARIO.TIPO_USUARIO_ID IS 'Código único que identifica el tipo de usuario';
COMMENT ON COLUMN TIPO_USUARIO.DESCRIPCION IS 'Descripción del tipo de usuario';
COMMENT ON COLUMN TIPO_USUARIO.TIPO_PERSONA IS 'Tipo Persona a la cual pertenece el Tipo de Usuario. Posibles valores: 1-Fisica, 2-Moral';
COMMENT ON COLUMN TIPO_USUARIO.ESTADO IS 'Estado del tipo de contacto. Posibles valores: AC = Activo, IN = Inactivo';

CREATE UNIQUE INDEX TIPO_USUARIO_IDX ON TIPO_USUARIO (TIPO_USUARIO_ID) ;
CREATE INDEX TIPO_PERSONA_IDX ON TIPO_USUARIO (TIPO_PERSONA) ;
CREATE INDEX TIPO_USUARIO_ESTADO_IDX ON TIPO_USUARIO (ESTADO) ;

ALTER TABLE TIPO_USUARIO ADD CONSTRAINT TIPO_USUARIO_PK PRIMARY KEY (TIPO_USUARIO_ID);
ALTER TABLE TIPO_USUARIO ADD CONSTRAINT TIPO_USUARIO_ESTADO_CK CHECK (ESTADO in ('AC', 'IN'));
ALTER TABLE TIPO_USUARIO ADD CONSTRAINT TIPO_USUARIO_TIPO_PERSONA_CK CHECK (TIPO_PERSONA in (1, 2));

GRANT REFERENCES ON TIPO_USUARIO TO PUBLIC;
