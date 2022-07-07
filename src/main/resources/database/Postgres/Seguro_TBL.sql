CREATE TABLE public.seguro (
	seguro_id serial4 NOT NULL,
	descripcion varchar(250) NOT NULL,
	estado varchar(2) NOT NULL,
	CONSTRAINT seguro_estado_ck CHECK (((estado)::text = ANY ((ARRAY['AC'::character varying, 'IN'::character varying])::text[]))),
	CONSTRAINT seguro_pkey PRIMARY KEY (seguro_id)
);