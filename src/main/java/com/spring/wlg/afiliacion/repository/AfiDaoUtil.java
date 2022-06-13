package com.spring.wlg.afiliacion.repository;

public class AfiDaoUtil {

    public static String FIND_SOLICTUD_AFILIACION ="SELECT " +
            "        SA.SOLICITUD_ID, " +
            "        SA.TIPO_IDENTIFICACION_ID, " +
            "        SA.CIUDADANO_ID, " +
            "        CIU.CEDULA, " +
            "        CIU.NSS, " +
            "        CIU.MUNICIPIO_ID AS MUNICIPIO_CIUDADANO, " +
            "        MUN_CIU.CODIGO_MUNICIPIO AS CODIGO_MUNICIPIO_CIUDADANO, " +
            "        PRO_CIU.CODIGO_PROVINCIA AS CODIGO_PROVINCIA_CIUDADANO, " +
            "        SAD.CIUDADANO_TITULAR_ID, " +
            "        SAD.CEDULA_TITULAR, " +
            "        SA.TIPO_AFILIADO, " +
            "        SAD.TIPO_DEPENDIENTE, " +
            "        SAD.PARENTESCO_ID, " +
            "        SA.ENTIDAD_ID, " +
            "        TE.SEGURO_ID, " +
            "        ENT.REGIMEN_ID, " +
            "        SA.INSTITUCION_PENSIONADO_ID,  " +
            "        SA.ESTADO, " +
            "        MOT.MOTIVO_ID " +
            "    FROM SOLICITUD_AFILIACION SA " +
            "    JOIN SOLICITUD_AFI_DEPENDIENTE SAD ON SA.SOLICITUD_ID = SAD.SOLICITUD_ID " +
            "    JOIN ENTIDAD ENT ON SA.ENTIDAD_ID = ENT.ENTIDAD_ID " +
            "    JOIN TIPO_ENTIDAD TE ON ENT.TIPO_ENTIDAD_ID = TE.TIPO_ENTIDAD_ID " +
            "    left join MOTIVO_ESTADO_SOL_AFI MOT on SA.SOLICITUD_ID = MOT.SOLICITUD_ID " +
            "    LEFT JOIN CIUDADANO CIU ON SA.CIUDADANO_ID = CIU.CIUDADANO_ID " +
            "    LEFT JOIN MUNICIPIO MUN_SA ON SA.MUNICIPIO_ID = MUN_SA.MUNICIPIO_ID " +
            "    LEFT JOIN PROVINCIA PRO_SA ON MUN_SA.PROVINCIA_ID = PRO_SA.PROVINCIA_ID " +
            "    LEFT JOIN MUNICIPIO MUN_CIU ON CIU.MUNICIPIO_ID = MUN_CIU.MUNICIPIO_ID " +
            "    LEFT JOIN PROVINCIA PRO_CIU ON MUN_CIU.PROVINCIA_ID = PRO_CIU.PROVINCIA_ID  " +
            "    WHERE rownum <= 500 ORDER BY  SA.SOLICITUD_ID DESC ";
}
