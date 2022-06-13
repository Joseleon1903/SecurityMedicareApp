package com.spring.security.medi.care.app.usuario.repository;

public class DaoUtil {


    public static String FIND_ALL_USERS_QUERY =
            "    SELECT " +
            "        US.USUARIO_ID, " +
            "        US.CODIGO, " +
            "        US.TIPO_USUARIO_ID, " +
            "        CO.POSICION," +
            "        CO.CORREO_CORPORATIVO," +
            "        CIU.CEDULA," +
            "        CIU.NSS, " +
            "        CIU.NOMBRE, " +
            "        CIU.PRIMER_APELLIDO, " +
            "        CIU.SEGUNDO_APELLIDO, " +
            "        CIU.FECHA_NACIMIENTO, " +
            "        CIU.GENERO, " +
            "        NA.DESCRIPCION AS NACIONALIDAD " +
            "    FROM USUARIO US " +
            "    JOIN CONTACTO CO ON US.CONTACTO_ID = CO.CONTACTO_ID " +
            "    JOIN CIUDADANO CIU ON CO.CIUDADANO_ID = CIU.CIUDADANO_ID " +
            "    JOIN NACIONALIDAD NA ON CIU.NACIONALIDAD_ID = NA.NACIONALIDAD_ID";


    public static String FIND_USERS_BY_CODE_QUERY ="SELECT " +
            "    US.USUARIO_ID, " +
            "    US.CODIGO, " +
            "    US.TIPO_USUARIO_ID, " +
            "    CO.CONTACTO_ID, " +
            "    TP.DESCRIPCION TIPO_USUARIO_DESCRIPCION, " +
            "    CO.POSICION, " +
            "    CO.CORREO_CORPORATIVO, " +
            "    CIU.CEDULA, " +
            "    CIU.NSS, " +
            "    CIU.NOMBRE, " +
            "    CIU.PRIMER_APELLIDO, " +
            "    CIU.SEGUNDO_APELLIDO, " +
            "    CIU.FECHA_NACIMIENTO, " +
            "    CIU.GENERO, " +
            "    NA.DESCRIPCION AS NACIONALIDAD " +
            "    FROM USUARIO US " +
            "    JOIN CONTACTO CO ON US.CONTACTO_ID = CO.CONTACTO_ID " +
            "    JOIN CIUDADANO CIU ON CO.CIUDADANO_ID = CIU.CIUDADANO_ID " +
            "    JOIN NACIONALIDAD NA ON CIU.NACIONALIDAD_ID = NA.NACIONALIDAD_ID " +
            "    JOIN TIPO_USUARIO TP ON US.TIPO_USUARIO_ID = TP.TIPO_USUARIO_ID " +
            "    WHERE UPPER(US.CODIGO) LIKE UPPER('%'|| ? ||'%')  ";



}
