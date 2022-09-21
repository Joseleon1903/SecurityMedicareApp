package com.spring.security.medi.care.app.commons;

public class DaoUtil {

    public static int DEFAULT_ROW_COUNT = 10;
    public static int DEFAULT_PAGE = 0;

    public static String ESTADO_AC = "AC";
    public static String ESTADO_IN = "IN";

    public static String parseEstadoColumn(String estado){

        if(ESTADO_AC.equals(ESTADO_AC)){
            return "ACTIVO";
        }
        return "INACTIVO";
    }

    public static Long getRegistrosRestantes(long total, int page, int size){
        long registros = total - (page*size);
        if(registros <= 0 ){
            return 0L;
        }
        return registros;
    }

}
