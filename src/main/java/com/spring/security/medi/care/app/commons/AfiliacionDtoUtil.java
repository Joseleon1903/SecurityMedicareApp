package com.spring.security.medi.care.app.commons;

/***
 *  afiliacion utility class
 */
public class AfiliacionDtoUtil {

    /**
     *  seguro
     */
    public static String SEGURO_VEJEZ = "FAMILIAR DE VEJEZ";
    public static String SEGURO_SALUD = "FAMILIAR DE SALUD";
    public static String SEGURO_LABORAL = "RIESGO LABORAL";
    public static String SEGURO_ACCIDENTE = "ACCIDENTE DE TRANSITO";
    public static String SEGURO_INFANTIL = "ESTANCIAS INFANTILES";

    public static long N_SEGURO_VEJEZ = 1;
    public static long N_SALUD = 2;
    public static long N_LABORAL = 3;
    public static long N_SEGURO_ACCIDENTE = 4;
    public static long N_SEGURO_INFANTIL = 5;

    /**
     * Regimen
     */
    public static int N_REGIMEN_CONTRIBUTIVO = 1;
    public static int N_REGIMEN_SUBSIDIADO = 2;

    public static String REGIMEN_CONTRIBUTIVO = "CONTRIBUTIVO";
    public static String REGIMEN_SUBSIDIADO = "SUBSIDIADO";

    /***
     * Tipo Afiliado
     */
    public static String C_TIPO_TITULAR = "T";
    public static String C_TIPO_DEPENDIENTE = "D";

    public static String V_TIPO_TITULAR = "TITULAR";
    public static String V_TIPO_DEPENDIENTE = "DEPENDIENTE";


    public static String C_ESTADO_PE = "PE";
    public static String C_ESTADO_RE = "RE";
    public static String C_ESTADO_OK = "OK";

    public static String C_ESTADO_AC = "AC";
    public static String C_ESTADO_IN = "IN";

    public static String V_ESTADO_PE = "PENDIENTE";
    public static String V_ESTADO_RE = "RECHAZADO";
    public static String V_ESTADO_OK = "ACEPTADO";

    private AfiliacionDtoUtil(){}

    /***
     *
     * @param seguro
     * @return
     */
    public static String convertSeguroId(Long seguro){
        String result = "";
        if (seguro.equals(N_SEGURO_VEJEZ)){
           return SEGURO_VEJEZ;
        }

        if (seguro.equals(N_SALUD)){
            return SEGURO_SALUD;
        }
        if (seguro.equals(N_LABORAL)){
            return SEGURO_LABORAL;
        }
        if (seguro.equals(N_SEGURO_ACCIDENTE)){
            return SEGURO_ACCIDENTE;
        }
        if (seguro.equals(N_SEGURO_INFANTIL)){
            return SEGURO_INFANTIL;
        }
        return result;
    }

    /**
     *
     * @param regimen
     * @return
     */
    public static String convertRegimenId(Integer regimen){
        String result = "";
        if (regimen.equals(N_REGIMEN_CONTRIBUTIVO)){
            return REGIMEN_CONTRIBUTIVO;
        }

        if (regimen.equals(N_REGIMEN_SUBSIDIADO)){
            return REGIMEN_SUBSIDIADO;
        }
        return result;
    }

    /***
     *
     * @param tipo
     * @return
     */
    public static String convertTipoAfiliado(String tipo){
        String result = "";
        if (tipo.equals(C_TIPO_TITULAR)){
            return V_TIPO_TITULAR;
        }

        if (tipo.equals(C_TIPO_DEPENDIENTE)){
            return V_TIPO_DEPENDIENTE;
        }
        return result;
    }

    public static String convertEstado(String estadoIn){
        String result = "";
        if (estadoIn.equals(C_ESTADO_OK)){
            return V_ESTADO_OK;
        }

        if (estadoIn.equals(C_ESTADO_PE)){
            return V_ESTADO_PE;
        }

        if (estadoIn.equals(C_ESTADO_RE)){
            return V_ESTADO_RE;
        }
        return result;
    }

}
