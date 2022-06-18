package com.spring.security.medi.care.app.catalogo.repository;

public class CatalogoDaoUtil {

    public static String FIND_CATALOGO_PARENTESCO ="SELECT " +
            "       PARE.PARENTESCO_ID," +
            "       PARE.DESCRIPCION, " +
            "       PARE.TIPO_DEPENDIENTE, " +
            "       PARE.GENERO, " +
            "       GC.DESCRIPCION AS GRADO_CONSANGUINIDAD, " +
            "       PARE.ESTADO  " +
            "       FROM PARENTESCO PARE " +
            "       JOIN GRADO_CONSANGUINIDAD GC ON PARE.GRADO_CONSANGUINIDAD_ID = GC.GRADO_CONSANGUINIDAD_ID " +
            "       WHERE 1 = (CASE WHEN ? IS NULL THEN 1 " +   // TIPO DEPENDIENTE
            "                       WHEN PARE.TIPO_DEPENDIENTE = ? THEN 1 " +
            "                       ELSE 0 END) " +
            "      AND 1 = (CASE WHEN ? IS NULL THEN 1 " +                // GENERO
            "                       WHEN PARE.GENERO  = ? THEN 1 " +
            "                       ELSE 0 END) " +
            " AND ROWNUM <= ? "+
            "     ORDER BY  PARE.PARENTESCO_ID ASC ";


    public static String FIND_CATALOGO_MOTIVO_ESTADO ="SELECT " +
            "    MOT.MOTIVO_ID, " +
            "    MOT.DESCRIPCION, " +
            "    MOT.ESTADO " +
            "FROM MOTIVO_ESTADO MOT " +
            "WHERE 1 = (CASE WHEN :P_MOTIVO_ID IS NULL THEN 1 " +
            "                WHEN :P_MOTIVO_ID = MOT.MOTIVO_ID THEN 1 " +
            "                ELSE 0 END) " +
            "AND   1 = (CASE WHEN :P_DESCRIPCION IS NULL THEN 1  " +
            "                WHEN UPPER(MOT.DESCRIPCION) LIKE UPPER('%'||:P_DESCRIPCION|| '%' ) THEN 1 " +
            "                ELSE 0 END) " +
            " AND ROWNUM <= ? "+
            " ORDER BY MOT.MOTIVO_ID ASC ";

    public static String FIND_CATALOGO_NACIONALIDAD = "SELECT NA.NACIONALIDAD_ID, " +
            "       NA.DESCRIPCION AS NACIONALIDAD,  " +
            "       NA.PAIS_ID , " +
            "       PA.NOMBRE AS NOMBRE_PAIS," +
            "       NA.ESTADO " +
            " FROM NACIONALIDAD NA " +
            " JOIN PAIS PA ON PA.PAIS_ID = NA.PAIS_ID "+
            " WHERE 1= (CASE WHEN :P_PAIS IS NULL THEN 1 " +                /// pais
            "               WHEN UPPER(NA.PAIS_ID) LIKE UPPER(:P_PAIS)  THEN 1 " +
            "               ELSE 0 END) "+
            "  AND 1= (CASE WHEN :P_NOMBRE IS NULL THEN 1 " +         // nombre pais
            "               WHEN UPPER(PA.NOMBRE) LIKE UPPER(:P_NOMBRE)  THEN 1 " +
            "               ELSE 0 END)              " +
            " AND ROWNUM <= :P_ROW "+
            " ORDER BY PA.NOMBRE ASC ";

}