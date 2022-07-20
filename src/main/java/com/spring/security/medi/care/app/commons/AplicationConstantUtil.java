package com.spring.security.medi.care.app.commons;

import java.util.Random;

public class AplicationConstantUtil {

    private AplicationConstantUtil(){}

    public static Integer SERVICIO_PANTALLA_SOLICITUD_AFILIACION = 301;
    public static String PARAMETRO_PENDIENTE_DEFINICION = "Valor no definido";
    public static String ESTADO_PE = "PE";

    public static Integer generateLoteId (){
        Random ran =  new Random();
        return ran.nextInt(Integer.SIZE - 1);
    }




}
