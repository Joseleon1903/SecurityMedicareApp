package com.spring.wlg.solicitud.dependiente.repository;

public class AfiDependienteUtil {

    public static String FIND_DEPENTIENTES_POR_TITULAR_QUERY =
            " SELECT AFI.AFILIACION_ID, " +
            "       SOL.SOLICITUD_ID, " +
            "       SS.DESCRIPCION AS SERVICIO, " +
            "       ENT.ENTIDAD_ID, " +
            "       ENT.DESCRIPCION AS NOMBRE_ENTIDAD, " +
            "       SOL.TIPO_IDENTIFICACION_ID, " +
            "       SOLD.NUI, " +
            "       SOLD.NSS, " +
            "       SOLD.CEDULA, " +
            "       SOL.NOMBRE, " +
            "       SOL.PRIMER_APELLIDO, " +
            "       SOLD.SEGUNDO_APELLIDO, " +
            "       SOLD.TIPO_DEPENDIENTE, " +
            "       SOL.TIPO_AFILIADO, " +
            "       PAR.DESCRIPCION AS PARENTESCO, " +
            "       NA.DESCRIPCION AS NACIONALIDAD, " +
            "       SOL.ESTADO, " +
            "       MOT.MOTIVO_ID, " +
            "       SE.SEGURO_ID, " +
            "       SOL.REGIMEN_ID, " +
            "       SOLD.ESTUDIANTE, " +
            "       SOLD.DISCAPACITADO, " +
            "       SOLD.CEDULA_TITULAR, " +
            "       SOLD.CIUDADANO_TITULAR_ID, " +
            "       SOLD.SOLICITUD_AFI_TITULAR_ID " +
            "      FROM SOLICITUD_AFILIACION SOL " +
            "        INNER JOIN ENTIDAD ENT ON SOL.ENTIDAD_ID = ENT.ENTIDAD_ID " +
            "        INNER JOIN TIPO_ENTIDAD TE ON TE.TIPO_ENTIDAD_ID = ENT.TIPO_ENTIDAD_ID " +
            "        INNER JOIN SOLICITUD_AFI_DEPENDIENTE SOLD ON SOL.SOLICITUD_ID = SOLD.SOLICITUD_ID " +
            "        INNER JOIN SEGURO SE ON SE.SEGURO_ID = TE.SEGURO_ID " +
            "        JOIN PARENTESCO PAR ON SOLD.PARENTESCO_ID = PAR.PARENTESCO_ID " +
            "        JOIN NACIONALIDAD NA ON SOLD.NACIONALIDAD_ID = NA.NACIONALIDAD_ID " +
            "        LEFT JOIN MOTIVO_ESTADO_SOL_AFI MOT ON SOL.SOLICITUD_ID = MOT.SOLICITUD_ID " +
            "        JOIN SERVICIO_SISTEMA SS ON SOL.SERVICIO_ID = SS.SERVICIO_ID " +
            "        LEFT JOIN AFILIACION AFI ON AFI.SOLICITUD_ID = SOL.SOLICITUD_ID " +
            "      WHERE SOLD.SOLICITUD_AFI_TITULAR_ID = ? " +  // P_SOLICITUD_AFI_TITULAR_ID
            "      AND SOL.TIPO_AFILIADO = 'D' " +
            "      AND 1 = (CASE WHEN ? IS NULL THEN 1 " +       // P_ESTADO
            "              WHEN ? = SOL.ESTADO THEN 1 " +
            "              ELSE 0 END) " +
            "       AND 1 = (CASE WHEN ? IS NULL THEN 1 " +      // P_TIPO_DEPENDIENTE
            "              WHEN ? = SOLD.TIPO_DEPENDIENTE THEN 1 " +
            "              ELSE 0 END) ";
}
