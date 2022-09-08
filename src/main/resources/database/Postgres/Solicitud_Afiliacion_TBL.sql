
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