INSERT INTO MOTIVO_ESTADO (MOTIVO_ID, DESCRIPCION,  ESTADO) VALUES (10606, 'Validar calidad de Cédula',  'AC');
INSERT INTO MOTIVO_ESTADO (MOTIVO_ID, DESCRIPCION,  ESTADO) VALUES (10607, 'Número telefónico inválido',  'AC');
INSERT INTO MOTIVO_ESTADO (MOTIVO_ID, DESCRIPCION,  ESTADO) VALUES (10608, 'Probable anomalía en los datos escritos por el afiliado',  'AC');
INSERT INTO MOTIVO_ESTADO (MOTIVO_ID, DESCRIPCION,  ESTADO) VALUES (10609, 'Datos no fueron suscritos por el afiliado',  'AC');
--MOTIVO PROPRIOS DEL SISTEMA NO BORRAR
INSERT INTO MOTIVO_ESTADO (MOTIVO_ID, DESCRIPCION,  ESTADO) VALUES (800, 'No existe un ciudadano en el sistema con el NSS o la cedula de la solicitud',  'AC');
INSERT INTO MOTIVO_ESTADO (MOTIVO_ID, DESCRIPCION,  ESTADO) VALUES (801, 'El ciudadnao ya tiene una solicitud acpetada para otra entidad',  'AC');
INSERT INTO MOTIVO_ESTADO (MOTIVO_ID, DESCRIPCION,  ESTADO) VALUES (804, 'Ya existe un ciudadano en el sistema con la misma identificación',  'AC');
INSERT INTO MOTIVO_ESTADO (MOTIVO_ID, DESCRIPCION,  ESTADO) VALUES (500, 'Error interno del sistema, contactar un administrador',  'AC');
INSERT INTO MOTIVO_ESTADO (MOTIVO_ID, DESCRIPCION,  ESTADO) VALUES (805, 'La password no conincide con la password de confirmación',  'AC');
INSERT INTO MOTIVO_ESTADO (MOTIVO_ID, DESCRIPCION,  ESTADO) VALUES (806, 'Existen datos requerido no proprocionados [username, correo primario y tipo usuario]',  'AC');
INSERT INTO MOTIVO_ESTADO (MOTIVO_ID, DESCRIPCION,  ESTADO) VALUES (807, 'Un motivo estado con el mismo motivo id ya existe en el sistema, no se aceptan motivos duplicados',  'AC');
