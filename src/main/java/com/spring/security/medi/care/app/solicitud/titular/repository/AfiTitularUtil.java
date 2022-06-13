package com.spring.security.medi.care.app.solicitud.titular.repository;

public class AfiTitularUtil {

    public static String BUSCAR_TITULAR_POR_SOLICITUD_QUERY = "SELECT AF.AFILIACION_ID," +
            "        SS.SOLICITUD_ID, " +
            "        SS.SERVICIO_ID, " +
            "        SS.LOTE_ID, " +
            "        SA.NUMERO_CONTRATO, " +
            "        SA.TIPO_PERSONA,  " +
            "        SS.ENTIDAD_ID,  " +
            "        SS.SEGURO_ID,  " +
            "        SS.REGIMEN_ID, " +
            "        AF.FECHA_AFILIACION, " +
            "        TA.DESCRIPCION AS TIPO_AFILIACION, " +
            "        SS.TIPO_IDENTIFICACION_ID, " +
            "        SA.CEDULA,  " +
            "        SS.NOMBRE,  " +
            "        SS.PRIMER_APELLIDO,  " +
            "        CI.SEGUNDO_APELLIDO,  " +
            "        SS.CIUDADANO_ID, " +
            "        SS.ESTADO,  " +
            "        MOT.MOTIVO_ID,  " +
            "        ME.DESCRIPCION AS DESCRIPCION_MOTIVO " +
            "FROM SOLICITUD_AFILIACION SS  " +
            "JOIN SOLICITUD_AFILIACION_TITULAR SA ON SS.SOLICITUD_ID = SA.SOLICITUD_ID " +
            "JOIN CIUDADANO CI ON CI.CIUDADANO_ID = SS.CIUDADANO_ID  " +
            "LEFT JOIN AFILIACION AF ON AF.SOLICITUD_ID = SS.SOLICITUD_ID " +
            "LEFT JOIN TIPO_AFILIACION TA ON AF.TIPO_AFILIACION_ID =TA.TIPO_AFILIACION_ID " +
            "LEFT JOIN MOTIVO_ESTADO_SOL_AFI MOT ON SS.SOLICITUD_ID = MOT.SOLICITUD_ID " +
            "LEFT JOIN MOTIVO_ESTADO ME ON MOT.MOTIVO_ID = ME.MOTIVO_ID " +
            "WHERE SS.CIUDADANO_ID = ? " + //CIUDADANO_ID
            "AND 1 = (CASE WHEN ? IS NULL THEN 1 " +           // ESTADO
            "              WHEN ? = SS.ESTADO THEN 1 " +
            "                ELSE 0 END) " +
            "AND 1 = (CASE WHEN ? IS NULL THEN 1 " +
            "             WHEN  ? <= SA.NUMERO_CONTRATO THEN 1 " + //NUMERO CONTRATO
            "               ELSE 0 END) " +
            "AND 1 = (CASE WHEN ? IS NULL THEN 1  " +
            "              WHEN ? = SA.TIPO_PERSONA THEN 1 " +    // TIPO_PERSONA
            "               ELSE 0 END) " +
            " AND 1 = (CASE WHEN ? IS NULL THEN 1  " +
            "               WHEN ? = SS.ENTIDAD_ID THEN 1 " +     // ENTIDAD_ID
            "                ELSE 0 END) ";



}
