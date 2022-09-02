package com.spring.security.medi.care.app.commons;

import java.util.Random;

public class AplicationConstantUtil {

    private AplicationConstantUtil() {
    }

    public static Integer SERVICIO_PANTALLA_SOLICITUD_AFILIACION = 301;
    public static String PARAMETRO_PENDIENTE_DEFINICION = "Valor no definido";
    public static String ESTADO_PE = "PE";

    public static long GENERAL_ERROR_INTERNO = 500;
    public static long NO_EXISTE_IDENTIFICACION_SOLICITUD = 800;
    public static long EXISTE_SOLICITUD_AC_PARA_CIUDADANO = 801;
    public static long EXISTE_ACTIVO_CON_IDENTIFCACION = 804;

    public static Integer generateLoteId() {
        Random ran = new Random();
        return ran.nextInt(Integer.SIZE - 1);
    }

}