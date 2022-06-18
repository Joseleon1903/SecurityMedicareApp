CREATE TABLE PARENTESCO
(
  PARENTESCO_ID                		NUMBER(3)    	NOT NULL,
  DESCRIPCION                  		VARCHAR2(40) 	NOT NULL,
  TIPO_DEPENDIENTE             		VARCHAR2(1) 	NOT NULL,
  PUEDE_REPETIRSE              		NUMBER(1) 		NOT NULL,
  GENERO                       		VARCHAR2(1),
  VALIDA_DIFERENCIA_EDAD       		NUMBER(1) 		NOT NULL,
  DIFERENCIA_EDAD_MINIMA       		NUMBER(2),
  TIPO_DIFERENCIA_EDAD         		NUMBER(1),
  EDAD_MINIMA                  		NUMBER(2),
  VALIDO_DISCAPACIDAD          		NUMBER(1) 		NOT NULL,
  VALIDO_ESTUDIANTE            		NUMBER(1) 		NOT NULL,
  PARENTESCO_CONYUGE           		NUMBER(1) 		NOT NULL,
  GRADO_CONSANGUINIDAD_ID      		NUMBER(2) 		NOT NULL,
  RELACIONADO_CONYUGE          		NUMBER(1) 		NOT NULL,
  RELACIONADO_GENERO           		NUMBER(1) 		NOT NULL,
  ESTADO                       		VARCHAR2(2) 	NOT NULL
)
TABLESPACE SIGMA_DATA;

COMMENT ON TABLE PARENTESCO IS 'Catálogo de parentescos del sistema';

COMMENT ON COLUMN PARENTESCO.PARENTESCO_ID IS 'Código que identifica el parentesco';
COMMENT ON COLUMN PARENTESCO.DESCRIPCION IS 'Descripción del parentesco';
COMMENT ON COLUMN PARENTESCO.TIPO_DEPENDIENTE IS 'Tipo de beneficiario. Posibles valores: D = Directo, A = Adicional';
COMMENT ON COLUMN PARENTESCO.PUEDE_REPETIRSE IS 'Indica si el parentesco puede repetirse en un núcleo familiar. Posibles valores: 0 = No, 1 = Si';
COMMENT ON COLUMN PARENTESCO.GENERO IS 'Género del parentesco. Posibles valores: M = Masculino, F = Femenino';
COMMENT ON COLUMN PARENTESCO.VALIDA_DIFERENCIA_EDAD IS 'Indica si para el parentesco se valida diferencia de edad entre el titular y el dependiente. Posibles valores: 0 = No, 1 = Si';
COMMENT ON COLUMN PARENTESCO.DIFERENCIA_EDAD_MINIMA IS 'Diferencia de edad mínima permitida entre el titular y el dependiente para el parentesco';
COMMENT ON COLUMN PARENTESCO.TIPO_DIFERENCIA_EDAD IS 'Indica si la diferencia de edad enviada es mayor o menor que la del titular. Posibles valores: 1 = Menor que el titular, 2 = Mayor que el titular';
COMMENT ON COLUMN PARENTESCO.EDAD_MINIMA IS 'Edad minima permitida para el parentesco';
COMMENT ON COLUMN PARENTESCO.VALIDO_DISCAPACIDAD IS 'Indica si es válido enviar una afiliación para un discapacitado con este parentesco. Posibles valores: 0 = No, 1 = Si';
COMMENT ON COLUMN PARENTESCO.VALIDO_ESTUDIANTE IS 'Indica si es válido enviar una afiliación para un estudiante con este parentesco. Posibles valores: 0 = No, 1 = Si';
COMMENT ON COLUMN PARENTESCO.PARENTESCO_CONYUGE IS 'Indica si hay parentesco con el cónyuge. Posibles valores: 0 = No, 1 = Si';
COMMENT ON COLUMN PARENTESCO.GRADO_CONSANGUINIDAD_ID IS 'Código del grado de consanguinidad entre el titular y dependiente';
COMMENT ON COLUMN PARENTESCO.RELACIONADO_CONYUGE IS 'Indica si el parentesco tiene una relación exclusiva con el cónyuge del núcleo familiar. Posibles valores: 0 = No, 1 = Si';
COMMENT ON COLUMN PARENTESCO.RELACIONADO_TITULAR IS 'Indica si el parentesco tiene una relación exclusiva con el titular del núcleo familiar.  Posibles valores: 0 = No, 1 = Si';
COMMENT ON COLUMN PARENTESCO.RELACIONADO_TUTELA IS 'Indica si está relacionado con la tutela. Posibles valores: 0 = No, 1 = Si';
COMMENT ON COLUMN PARENTESCO.RELACIONADO_GENERO IS 'Indica si está relacionado con el género. Posibles valores: 0 = No, 1 = Si';
COMMENT ON COLUMN PARENTESCO.PARENTESCO_CAMBIO_TITULAR_ID IS 'Código que identifica el parentesco';
COMMENT ON COLUMN PARENTESCO.TIPO_PERSONA_TITULAR IS 'Número que muestra con cual tipo de persona (1-Física o 2-Moral), esta relacionado el titular con el dependiente, tomando en cuenta el parentesco.';
COMMENT ON COLUMN PARENTESCO.NIVEL_PREFERENCIA IS 'Nivel de preferencia dentro del parentesco.';
COMMENT ON COLUMN PARENTESCO.PARENTESCO_INTERCAMBIO_INFO_ID IS 'Código de parentesco utilizado para el intercambio de información.';
COMMENT ON COLUMN PARENTESCO.ESTADO IS 'Estado del parentesco. Posibles valores: AC = Activo, IN = Inactivo';

CREATE UNIQUE INDEX PARENTESCO_IDX ON PARENTESCO(PARENTESCO_ID) TABLESPACE SIGMA_INDEX;
CREATE INDEX PTSCO_GRADO_CONSANGUINIDAD_IDX ON PARENTESCO(GRADO_CONSANGUINIDAD_ID) TABLESPACE SIGMA_INDEX;

ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_PK PRIMARY KEY (PARENTESCO_ID);
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_GRADO_CONSG_FK FOREIGN KEY (GRADO_CONSANGUINIDAD_ID) REFERENCES GRADO_CONSANGUINIDAD(GRADO_CONSANGUINIDAD_ID);
ALTER TABLE PARENTESCO ADD CONSTRAINT PTSCO_PTSCO_CAMBIO_TIT_FK FOREIGN KEY (PARENTESCO_CAMBIO_TITULAR_ID) REFERENCES PARENTESCO(PARENTESCO_ID);
ALTER TABLE PARENTESCO ADD CONSTRAINT PTSCO_PTSCO_INTER_INF_FK FOREIGN KEY (PARENTESCO_INTERCAMBIO_INFO_ID) REFERENCES PARENTESCO(PARENTESCO_ID);
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_TIPO_DEPENDIENTE_CK CHECK (TIPO_DEPENDIENTE IN ('D', 'A'));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_PUEDE_REPETIRSE_CK CHECK (PUEDE_REPETIRSE IN (0, 1));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_GENERO_CK CHECK (GENERO IN ('M', 'F'));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_VALIDA_DIF_EDAD_CK CHECK (VALIDA_DIFERENCIA_EDAD IN (0, 1));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_TIPO_DIF_EDAD_CK CHECK (TIPO_DIFERENCIA_EDAD IN (1, 2));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_VAL_DISCAPACIDAD_CK CHECK (VALIDO_DISCAPACIDAD IN (0, 1));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_VAL_ESTUDIANTE_CK CHECK (VALIDO_ESTUDIANTE IN (0, 1));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_PTSCO_CONYUGE_CK CHECK (PARENTESCO_CONYUGE IN (0, 1));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_REL_CONYUGE_CK CHECK (RELACIONADO_CONYUGE IN (0, 1));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_RELACIONADO_TIT_CK CHECK (RELACIONADO_TITULAR IN (0, 1));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_REL_TUTELA_CK CHECK (RELACIONADO_TUTELA IN (0, 1));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_REL_GENERO_CK CHECK (RELACIONADO_GENERO IN (0, 1));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_TIPO_PERSONA_TIT_CK CHECK (TIPO_PERSONA_TITULAR IN (1, 2));
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_ESTADO_CK CHECK (ESTADO IN ('AC', 'IN'));
