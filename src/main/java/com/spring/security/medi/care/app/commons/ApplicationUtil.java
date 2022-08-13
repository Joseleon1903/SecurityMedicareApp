package com.spring.security.medi.care.app.commons;

// import com.pluto.aplication.model.dto.ErrorData;
// import com.pluto.aplication.model.dto.ShowTableData;
// import com.pluto.aplication.model.entity.ErrorException;
// import com.pluto.aplication.model.entity.Task;
// import com.pluto.aplication.service.interfaces.ErrorExceptionService;
// import org.springframework.ui.Model;

import com.spring.security.medi.care.app.ciudadano.type.CiudadanoDto;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ApplicationUtil {

    private ApplicationUtil(){}

    /**
     *  return true if Strinf is null or is empty
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

    // public static void validateErrorPage(String error, Model model, ErrorExceptionService errorExceptionService){
    //     if(ApplicationUtil.isStringNullOrEmpty(error)){
    //         ErrorException errorEntity = errorExceptionService.findByCode(Long.parseLong(error));
    //         ErrorData data = new ErrorData();
    //         data.setId(errorEntity.getId());
    //         data.setCode(errorEntity.getCode()+"");
    //         data.setTittle("Application server error");
    //         data.setDescription(errorEntity.getDescription());
    //         model.addAttribute("errorBean",data);
    //     }else{
    //         ErrorData data = new ErrorData();
    //         data.setId(0L);
    //         data.setCode("");
    //         data.setTittle("Application server error");
    //         data.setDescription("");
    //         model.addAttribute("errorBean",data);
    //     }
    // }

    // public static ShowTableData getShowDataTable(int entry, int total){

    //     ShowTableData show = new ShowTableData();

    //     int showItem  = 0;
    //     int pageTotal = (total/ entry) +1;
    //     show.setShowEntry(entry);
    //     show.setTotalElement(total);

    //     if(entry == total){
    //         showItem = entry;
    //     }else{
    //         showItem = total % entry;
    //     }
    //     show.setShowItem(showItem);

    //     List<Integer> intList = new ArrayList<>();
    //     for (int id = 0; id < pageTotal; id ++) {
    //         int obj = Integer.MAX_VALUE;
    //         intList.add(obj);
    //     }
    //     show.setPageTotal(intList);

    //     return show;
    // }

    // public static Boolean IsDoneConvert(String value){

    //     if("COMPLETE".equalsIgnoreCase(value)){
    //         return true;
    //     }
    //     if("PENDING".equalsIgnoreCase(value)){
    //         return false;
    //     }
    //     return null;
    // }

    public static String containQueryValue(String value){
        if(!ApplicationUtil.isStringNullOrEmpty(value)){
            return "%%";
        }
        return "%"+ value+"%";
    }


}