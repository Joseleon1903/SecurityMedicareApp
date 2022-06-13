package com.spring.security.medi.care.app.commons;

public class DaoUtil {

    public static int DEFAULT_ROW_COUNT = 5;
    public static String ESTADO_AC = "AC";
    public static String ESTADO_IN = "IN";

    public static String parseEstadoColumn(String estado){

        if(ESTADO_AC.equals(ESTADO_AC)){
            return "ACTIVO";
        }
        return "INACTIVO";
    }

}
