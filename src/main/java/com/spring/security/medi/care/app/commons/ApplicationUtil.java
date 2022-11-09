package com.spring.security.medi.care.app.commons;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ApplicationUtil {

    private ApplicationUtil(){}

    /**
     *  return true if String is null or is empty
     * 
     * @param text
     * @return boolean 
     */
    public static boolean isStringNullOrEmpty(String text){
        if(text != null && !text.trim().isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(Object date){
        if(date != null){
            return true;
        }
        return false;
    }

    /**
     * 
     * @param beginDate
     * @return
     */
    public static String timePastFromDate(Date beginDate){
        Date currentTime =  new Date();
        long diff = currentTime.getTime() - beginDate.getTime();//as given
        long minutes = TimeUnit.MILLISECONDS.toMinutes(diff); 
        if(minutes <=0){
            return "";
        }
        return minutes+" minutes ago";
    }

    public static String containQueryValue(String value){
        if(!ApplicationUtil.isStringNullOrEmpty(value)){
            return "%%";
        }
        return "%"+ value+"%";
    }


}