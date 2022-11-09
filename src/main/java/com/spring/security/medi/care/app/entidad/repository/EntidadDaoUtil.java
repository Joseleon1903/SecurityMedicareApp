package com.spring.security.medi.care.app.entidad.repository;

public class EntidadDaoUtil {

    private EntidadDaoUtil(){}


    public static String FIND_ALL_ENTIDADES = "SELECT " +
            "    DISTINCT " +
            "    ENT.ENTIDAD_ID, " +
            "    ENT.CLAVE_ENTIDAD, " +
            "    ENT.SIGLA, " +
            "    ENT.DESCRIPCION AS DESCRIPCION_ENTIDAD, " +
            "    ENT.RNC, " +
            "    ENT.ENTIDAD_SUPERVISORA_ID, " +
            "    TE.TIPO_ENTIDAD_ID, " +
            "    TE.DESCRIPCION AS DESCRIPCION_TIPO_ENTIDAD, " +
            "    TE.SEGURO_ID, " +
            "    SEG.DESCRIPCION AS DESCRIPCION_SEGURO, " +
            "    ENT.REGIMEN_ID, " +
            "    REG.DESCRIPCION AS DESCRIPCION_REGIMEN, " +
            "    ENT.ESTADO " +
            "FROM ENTIDAD ENT " +
            "JOIN TIPO_ENTIDAD TE ON ENT.TIPO_ENTIDAD_ID = TE.TIPO_ENTIDAD_ID " +
            "JOIN SEGURO SEG ON TE.SEGURO_ID = SEG.SEGURO_ID " +
            "JOIN REGIMEN REG ON ENT.REGIMEN_ID = ENT.REGIMEN_ID ";


    public static String FIND_SEGURO_REGIMEN_PARAMETERS = "SELECT " +
            "    DISTINCT " +
            "    ENT.ENTIDAD_ID, " +
            "    ENT.CLAVE_ENTIDAD, " +
            "    ENT.SIGLA, " +
            "    ENT.DESCRIPCION AS DESCRIPCION_ENTIDAD, " +
            "    ENT.RNC, " +
            "    ENT.ENTIDAD_SUPERVISORA_ID, " +
            "    TE.TIPO_ENTIDAD_ID, " +
            "    TE.DESCRIPCION AS DESCRIPCION_TIPO_ENTIDAD, " +
            "    TE.SEGURO_ID, " +
            "    SEG.DESCRIPCION AS DESCRIPCION_SEGURO, " +
            "    ENT.REGIMEN_ID, " +
            "    REG.DESCRIPCION AS DESCRIPCION_REGIMEN, " +
            "    ENT.ESTADO " +
            "FROM ENTIDAD ENT " +
            "JOIN TIPO_ENTIDAD TE ON ENT.TIPO_ENTIDAD_ID = TE.TIPO_ENTIDAD_ID " +
            "JOIN SEGURO SEG ON TE.SEGURO_ID = SEG.SEGURO_ID " +
            "JOIN REGIMEN REG ON ENT.REGIMEN_ID = ENT.REGIMEN_ID " +
            "WHERE ? = TE.SEGURO_ID AND ? = ENT.REGIMEN_ID " +
            "AND 1 = (CASE WHEN ? IS NULL THEN 1 " +
            "              WHEN ? IS NOT NULL AND UPPER(ENT.DESCRIPCION) LIKE '%'|| UPPER(?)|| '%' THEN 1 " +
            "              ELSE 0 END) ";

    public static String getIconUrl(String descripcion){

        if(descripcion.toUpperCase().contains("universal".toUpperCase())){
            return "/img/ars-universal.png";
        }

        if(descripcion.toUpperCase().contains("cmd".toUpperCase())){
            return "/img/ARS-CMD.png";
        }

        if(descripcion.toUpperCase().contains("Renacer".toUpperCase())){
            return "/img/ARS-Renacer.png";
        }
        if(descripcion.toUpperCase().contains("asemap".toUpperCase())){
            return "/img/ars_asemap.png";
        }
        if(descripcion.toUpperCase().contains("futuro".toUpperCase())){
            return "/img/ars_futuro.png";
        }
        if(descripcion.toUpperCase().contains("humano".toUpperCase())){
            return "/img/ars_humano.png";
        }
        if(descripcion.toUpperCase().contains("metasalud".toUpperCase())){
            return "/img/ars_metasalud_logo.png";
        }
        if(descripcion.toUpperCase().contains("reserva".toUpperCase())){
            return "/img/ars_reserva.png";
        }
        if(descripcion.toUpperCase().contains("segura".toUpperCase())){
            return "/img/ars_saludsegura.png";
        }
        if(descripcion.toUpperCase().contains("semma".toUpperCase())){
            return "/img/ars_semma.png";
        }
        if(descripcion.toUpperCase().contains("sigma".toUpperCase())){
            return "/img/ars_png";
        }
        if(descripcion.toUpperCase().contains("gma".toUpperCase())){
            return "/img/arsGma.png";
        }

        return "/img/unipago_logo.png";
    }

}
