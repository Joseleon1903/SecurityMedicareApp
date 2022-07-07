package com.spring.security.medi.care.app.commons;

import com.spring.security.medi.care.app.controller.page.CatalogoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ViewBaseContext {

    protected static final Logger logger = LoggerFactory.getLogger(CatalogoController.class);

    protected abstract void init();

    public ViewBaseContext(){
        init();
    }

    /***
     *
     * @param rowNumber
     * @return
     */
    public int parserRowCounter(String rowNumber){
        logger.info("Entering parserRowCounter");
        int rowN =DaoUtil.DEFAULT_ROW_COUNT;
        try{
          rowN = Integer.parseInt(rowNumber);
        }catch (Exception ex){
           logger.error("Error parseando rowCount");
        }
        logger.info("Exiting parserRowCounter");
        return rowN;
    }


}