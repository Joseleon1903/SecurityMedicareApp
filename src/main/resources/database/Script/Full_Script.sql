--****************************
-- DATABASE MEDICARE_DATABASE
--***************************

CREATE DATABASE "medicare_database" WITH TEMPLATE = template0 ENCODING = 'UTF8';

GRANT ALL PRIVILEGES ON DATABASE medicare_database TO postgres;

--****************************
-- TABLE MOTIVO_ESTADO
--***************************
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

--****************************
-- TABLE SERVICIO_SISTEMA
--***************************
CREATE TABLE SERVICIO_SISTEMA
(
  SERVICIO_ID        SERIAL PRIMARY KEY,
  DESCRIPCION        VARCHAR(250) NOT NULL,
  FECHA_CREACION     DATE NOT NULL,
  ESTADO             VARCHAR(2)   NOT NULL
);

COMMENT ON TABLE SERVICIO_SISTEMA IS 'Catalogo de servicios de entidades asociadas al Sistema';

COMMENT ON COLUMN SERVICIO_SISTEMA.SERVICIO_ID IS 'Codigo que identifica el servicio sistema';
COMMENT ON COLUMN SERVICIO_SISTEMA.DESCRIPCION IS 'Descripcion del servicio sistema';
COMMENT ON COLUMN SERVICIO_SISTEMA.FECHA_CREACION IS 'Fecha creacion del registro con el servicio sistema.';
COMMENT ON COLUMN SERVICIO_SISTEMA.ESTADO IS 'Estado del servicio. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE SERVICIO_SISTEMA ADD CONSTRAINT SERVICIO_SISTEMA_ESTADO_CK CHECK (ESTADO in ('AC', 'IN'));

--****************************
-- TABLE MUNICIPIO
--***************************
CREATE TABLE MUNICIPIO
(
  MUNICIPIO_ID     SERIAL PRIMARY KEY,
  DESCRIPCION      VARCHAR(150) NOT NULL,
  CODIGO_MUNICIPIO VARCHAR(4)   NOT NULL,
  PROVINCIA_ID     INT     NOT NULL,
  ESTADO           VARCHAR(2)   NOT NULL
);

COMMENT ON TABLE MUNICIPIO IS 'Repositorio que aloja los municipios en los que estan divididas las localidades de salud';

COMMENT ON COLUMN MUNICIPIO.MUNICIPIO_ID IS 'Codigo con el que se identifica el municipio en el catalogo de municipio';
COMMENT ON COLUMN MUNICIPIO.DESCRIPCION IS 'Nombre del municipio registrado';
COMMENT ON COLUMN MUNICIPIO.CODIGO_MUNICIPIO IS 'Codigo conocido por el negocio con el que se registra el municipio en el catalogo de municipio';
COMMENT ON COLUMN MUNICIPIO.PROVINCIA_ID IS 'Codigo con el que se identifica la provincia en el catalogo de provincias';
COMMENT ON COLUMN MUNICIPIO.ESTADO IS 'Estado del municipio. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE MUNICIPIO ADD CONSTRAINT MUNICIPIO_ESTADO_CK CHECK (ESTADO in ('AC', 'IN'));

--****************************
-- TABLE SEGURO
--***************************
CREATE TABLE SEGURO (
	seguro_id serial4 NOT NULL,
	descripcion varchar(250) NOT NULL,
	estado varchar(2) NOT NULL,
	CONSTRAINT seguro_estado_ck CHECK (((estado)::text = ANY ((ARRAY['AC'::character varying, 'IN'::character varying])::text[]))),
	CONSTRAINT seguro_pkey PRIMARY KEY (seguro_id)
);
--****************************
-- TABLE NACIONALIDAD
--***************************
CREATE TABLE NACIONALIDAD (
	NACIONALIDAD_ID serial4 NOT NULL,
	DESCRIPCION varchar(255) NOT NULL,
	PAIS_ID varchar(255) NOT NULL,
	ESTADO varchar(10) NULL,
	CONSTRAINT nacionalidad_pkey PRIMARY KEY (nacionalidad_id)
);

COMMENT ON TABLE NACIONALIDAD IS 'Repositorio que aloja las nacionalidades en los que estan divididas las localidades de salud';

COMMENT ON COLUMN NACIONALIDAD.NACIONALIDAD_ID IS 'Codigo con el que se identifica la nacionalidad en el catalogo de municipio';
COMMENT ON COLUMN NACIONALIDAD.DESCRIPCION IS 'Nombre de la nacionalidad registrado';
COMMENT ON COLUMN NACIONALIDAD.PAIS_ID IS 'Codigo que identifica un pais';
COMMENT ON COLUMN NACIONALIDAD.ESTADO IS 'Estado Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE NACIONALIDAD ADD CONSTRAINT NACIONALIDAD_ESTADO_CK CHECK (ESTADO in ('AC', 'IN'));


--****************************
-- TABLE INSTITUCION_PENSIONADO
--***************************
CREATE TABLE INSTITUCION_PENSIONADO
(
  INSTITUCION_PENSIONADO_ID    SERIAL PRIMARY KEY,
  DESCRIPCION                  VARCHAR(200) NOT NULL,
  ESTADO                       VARCHAR(2)   NOT NULL
);

COMMENT ON TABLE INSTITUCION_PENSIONADO IS 'Repositorio que almacena las instituciones de pensionados.';

COMMENT ON COLUMN INSTITUCION_PENSIONADO.INSTITUCION_PENSIONADO_ID IS 'Código único que identifica la institución de pensionado';
COMMENT ON COLUMN INSTITUCION_PENSIONADO.DESCRIPCION IS 'Descripción de la institución de pensionado';
COMMENT ON COLUMN INSTITUCION_PENSIONADO.ESTADO IS 'Estado de la Institución de Pensionado. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE INSTITUCION_PENSIONADO ADD CONSTRAINT INSTITUCION_PENSIONADO_ST_CK CHECK (ESTADO IN ('AC', 'IN'));

--****************************
-- TABLE TIPO_ENTIDAD
--***************************
CREATE TABLE TIPO_ENTIDAD
(
  TIPO_ENTIDAD_ID        SERIAL PRIMARY KEY,
  DESCRIPCION            VARCHAR(150) NOT NULL,
  SEGURO_ID              INT ,
  ESTADO                 VARCHAR(2)   NOT NULL
);

COMMENT ON TABLE TIPO_ENTIDAD IS 'Catalogo de tipos de entidades asociadas al Sistema';

COMMENT ON COLUMN TIPO_ENTIDAD.TIPO_ENTIDAD_ID IS 'Codigo que identifica el tipo de entidad';
COMMENT ON COLUMN TIPO_ENTIDAD.DESCRIPCION IS 'Descripcion del tipo de entidad';
COMMENT ON COLUMN TIPO_ENTIDAD.SEGURO_ID IS 'Codigo que identifica el seguro';
COMMENT ON COLUMN TIPO_ENTIDAD.ESTADO IS 'Estado del tipo de entidad. Posibles valores: AC = Activo, IN = Inactivo';


ALTER TABLE TIPO_ENTIDAD ADD CONSTRAINT TIPO_ENTIDAD_SEGURO_FK FOREIGN KEY (SEGURO_ID) REFERENCES SEGURO(SEGURO_ID);
ALTER TABLE TIPO_ENTIDAD ADD CONSTRAINT TIPO_ENTIDAD_ESTADO_CK CHECK (ESTADO in ('AC', 'IN'));

--****************************
-- TABLE TIPO_USUARIO
--***************************
CREATE TABLE TIPO_USUARIO
(
  TIPO_USUARIO_ID  SERIAL PRIMARY KEY,
  DESCRIPCION      VARCHAR(150) NOT NULL,
  ESTADO           VARCHAR(2)   NOT NULL
);

COMMENT ON TABLE TIPO_USUARIO IS 'Código único que identifica el tipo de contacto';

COMMENT ON COLUMN TIPO_USUARIO.TIPO_USUARIO_ID IS 'Código único que identifica el tipo de usuario';
COMMENT ON COLUMN TIPO_USUARIO.DESCRIPCION IS 'Descripción del tipo de usuario';
COMMENT ON COLUMN TIPO_USUARIO.ESTADO IS 'Estado del tipo de contacto. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE TIPO_USUARIO ADD CONSTRAINT TIPO_USUARIO_ESTADO_CK CHECK (ESTADO in ('AC', 'IN'));


--****************************
-- TABLE ENTIDAD
--***************************
CREATE TABLE ENTIDAD
(
  ENTIDAD_ID                   	SERIAL PRIMARY KEY,
  TIPO_ENTIDAD_ID              	INT     NOT NULL,
  CLAVE_ENTIDAD                	INT     NOT NULL,
  SIGLA                        	VARCHAR(10),
  DESCRIPCION                  	VARCHAR(150) NOT NULL,
  REGIMEN_ID                   	INT,
  RNC                          	VARCHAR(9),
  ENTIDAD_SUPERVISORA_ID       	INT,
  ESTADO                       	VARCHAR(2)   NOT NULL,
  PARTICIPA_AFILIACION_AUT      BOOL  DEFAULT FALSE NOT NULL
);


COMMENT ON TABLE ENTIDAD IS 'Catalogo de Entidades asociadas al Sistema';

COMMENT ON COLUMN ENTIDAD.ENTIDAD_ID IS 'Codigo que identifica la Entidad en el sistema';
COMMENT ON COLUMN ENTIDAD.TIPO_ENTIDAD_ID IS 'Codigo que identifica el Tipo de Entidad a la que pertenece la entidad';
COMMENT ON COLUMN ENTIDAD.CLAVE_ENTIDAD IS 'Codigo que identifica la Entidad en el SDSS';
COMMENT ON COLUMN ENTIDAD.SIGLA IS 'Siglas de la Entidad';
COMMENT ON COLUMN ENTIDAD.DESCRIPCION IS 'Descripcion de la Entidad';
COMMENT ON COLUMN ENTIDAD.REGIMEN_ID IS 'Codigo del regimen';
COMMENT ON COLUMN ENTIDAD.PARTICIPA_AFILIACION_AUT IS 'Indicador que determina si la entidad participa en el proceso de afiliacion automatica. Posibles valores: 0 = No, 1 = Si';
COMMENT ON COLUMN ENTIDAD.RNC IS 'RNC que identifica la entidad';
COMMENT ON COLUMN ENTIDAD.ENTIDAD_SUPERVISORA_ID IS 'Codigo que identifica la Entidad supervisora en el sistema';
COMMENT ON COLUMN ENTIDAD.ESTADO IS 'Estado de la Entidad. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE ENTIDAD ADD CONSTRAINT ENTIDAD_TIPO_ENTIDAD_FK FOREIGN KEY (TIPO_ENTIDAD_ID) REFERENCES TIPO_ENTIDAD(TIPO_ENTIDAD_ID);
ALTER TABLE ENTIDAD ADD CONSTRAINT ESTADO_ENTIDAD_CK CHECK (ESTADO in ('AC', 'IN'));

--****************************
-- TABLE CIUDADANO
--***************************
CREATE TABLE CIUDADANO
(
  CIUDADANO_ID                  SERIAL PRIMARY KEY,
  CEDULA                        VARCHAR(11),
  NSS                           VARCHAR(11)    NOT NULL,
  NOMBRE                        VARCHAR(50) NOT NULL,
  PRIMER_APELLIDO               VARCHAR(40) NOT NULL,
  SEGUNDO_APELLIDO              VARCHAR(40),
  MUNICIPIO_ID                  INT,
  NACIONALIDAD_ID               INT,
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
COMMENT ON COLUMN CIUDADANO.FECHA_NACIMIENTO  IS 'Fecha de nacimiento del ciudadano';
COMMENT ON COLUMN CIUDADANO.GENERO  IS 'Gonero del Ciudadano. Posibles valores: M = Masculino, F = Femenino';
COMMENT ON COLUMN CIUDADANO.ESTADO IS 'Estado del ciudadano. Posibles valores: AC = Activo, IN = Inactivo';

ALTER TABLE CIUDADANO ADD CONSTRAINT CIUDADANO_MUNICIPIO_FK FOREIGN KEY (MUNICIPIO_ID) REFERENCES MUNICIPIO(MUNICIPIO_ID);
ALTER TABLE CIUDADANO ADD CONSTRAINT CIUDADANO_NACIONALIDAD_FK FOREIGN KEY (NACIONALIDAD_ID) REFERENCES NACIONALIDAD(NACIONALIDAD_ID);
ALTER TABLE CIUDADANO ADD CONSTRAINT CIUDADANO_GENERO_CK CHECK (GENERO IN ('F', 'M'));
ALTER TABLE CIUDADANO ADD CONSTRAINT CIUDADANO_ESTADO_CK CHECK (ESTADO IN ('AC', 'IN'));

--****************************
-- TABLE CONTACTO
--***************************
CREATE TABLE CONTACTO
(
  CONTACTO_ID                  SERIAL PRIMARY KEY,
  DESCRIPCION                  VARCHAR(150),
  CORREO_PRIMARIO              VARCHAR(128) NOT NULL,
  CORREO_ALTERNO               VARCHAR(128),
  POSICION                     VARCHAR(60),
  FECHA_CREACION               DATE          NOT NULL,
  FECHA_ULTIMO_CAMBIO          timestamp,
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
--****************************
-- TABLE USUARIO
--***************************
CREATE TABLE public.usuario (
	usuario_id int8 NOT NULL,
	codigo varchar(255) NULL,
	estado varchar(255) NULL,
	fecha_ultimo_cambio timestamp NULL,
	llave_encriptacion varchar(255) NULL,
	profile_picture varchar(255) NULL,
	contacto_id int8 NULL,
	tipo_usuario_id int8 NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (usuario_id)
);


-- public.usuario foreign keys

ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_CONTACTO_FK FOREIGN KEY (CONTACTO_ID) REFERENCES CONTACTO(CONTACTO_ID);
ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_TIPO_USUARIO_FK FOREIGN KEY (TIPO_USUARIO_ID) REFERENCES TIPO_USUARIO(TIPO_USUARIO_ID);
ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_ESTADO_CK CHECK (ESTADO IN ('AC', 'IN'));

--******************************
-- TABLE SOLICITUD_AFILIACION
--*****************************

CREATE TABLE solicitud_afiliacion (
	solicitud_id serial4 NOT NULL,
	servicio_id int4 NOT NULL,
	lote_id int4 NULL,
	entidad_id int4 NOT NULL,
	seguro_id int4 NOT NULL,
	regimen_id int4 NOT NULL,
	tipo_afiliado varchar(1) NOT NULL,
	tipo_identificacion_id int4 NOT NULL,
	cedula varchar(25) NULL,
	nss varchar(25) NULL,
	cedula_titular varchar(25) NULL,
	nombre varchar(50) NOT NULL,
	primer_apellido varchar(40) NOT NULL,
	automatica bool NOT NULL,
	institucion_pensionado_id int4 NULL,
	clave_institucion_pensionado int4 NULL,
	estado varchar(2) NOT NULL,
	fecha_recepcion date NOT NULL,
	municipio_id int4 NULL,
	ciudadano_id int4 NULL,
	nacionalidad_id int4 NULL,
	motivo_id int4 NULL,
	fecha_ultimo_cambio date NOT NULL,
	CONSTRAINT sol_afiliacion_tipo_afi_ck CHECK (((tipo_afiliado)::text = ANY ((ARRAY['D'::character varying, 'T'::character varying])::text[]))),
	CONSTRAINT solicitud_afiliacion_estado_ck CHECK (((estado)::text = ANY ((ARRAY['OK'::character varying, 'PE'::character varying, 'RE'::character varying])::text[]))),
	CONSTRAINT solicitud_afiliacion_pkey PRIMARY KEY (solicitud_id)
);


-- public.solicitud_afiliacion foreign keys

ALTER TABLE public.solicitud_afiliacion ADD CONSTRAINT sol_afiliacion_ciudadano_fk FOREIGN KEY (ciudadano_id) REFERENCES public.ciudadano(ciudadano_id);
ALTER TABLE public.solicitud_afiliacion ADD CONSTRAINT sol_afiliacion_entidad_fk FOREIGN KEY (entidad_id) REFERENCES public.entidad(entidad_id);
ALTER TABLE public.solicitud_afiliacion ADD CONSTRAINT sol_afiliacion_nacionalidad_fk FOREIGN KEY (nacionalidad_id) REFERENCES public.nacionalidad(nacionalidad_id);
ALTER TABLE public.solicitud_afiliacion ADD CONSTRAINT sol_afiliacion_instt_pen_fk FOREIGN KEY (institucion_pensionado_id) REFERENCES public.institucion_pensionado(institucion_pensionado_id);
ALTER TABLE public.solicitud_afiliacion ADD CONSTRAINT sol_afiliacion_municipio_fk FOREIGN KEY (municipio_id) REFERENCES public.municipio(municipio_id);
ALTER TABLE public.solicitud_afiliacion ADD CONSTRAINT solicitud_afiliacion_seguro_fk FOREIGN KEY (seguro_id) REFERENCES public.seguro(seguro_id);
ALTER TABLE public.solicitud_afiliacion ADD CONSTRAINT solicitud_afiliacion_motivo_fk FOREIGN KEY (motivo_id) REFERENCES public.motivo_estado(motivo_id);
ALTER TABLE public.solicitud_afiliacion ADD CONSTRAINT solicitud_afiliacion_servicio_sistema_fk FOREIGN KEY (servicio_id) REFERENCES public.servicio_sistema(servicio_id);

--******************************
-- TABLE IMAGED_STORED
--*****************************
CREATE TABLE imaged_stored (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE),
	creation_date timestamp NULL,
	file_download_uri varchar(255) NULL,
	file_type varchar(255) NULL,
	file_view_uri varchar(255) NULL,
	"name" varchar(255) NULL,
	"size" int8 NOT NULL,
	update_date timestamp NULL,
	CONSTRAINT imaged_stored_pkey PRIMARY KEY (id)
);