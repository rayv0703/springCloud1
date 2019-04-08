package com.broada.cm.log;



import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


/*

public class CommonLogger {

    Logger logger;

    @SuppressWarnings("rawtypes")
    public CommonLogger(Class c){
        logger=Logger.getLogger(c);
    }

    public void info(String message){
        logger.info(message);
    }
    public void info(String message,Throwable t){
        logger.info(message,t);
    }

    public void error(String message){
        logger.error(message);
    }
    public void error(String message,Throwable t){
        logger.error(message,t);
    }

    public void debug(String message){
        logger.debug(message);
    }
    public void debug(String message,Throwable t){
        logger.debug(message,t);
    }

    public void log(Exception ex, HttpServletRequest request){
        logger.error("*********异常开始*********");
        logger.error(ex);
        logger.error("请求地址: "+ request.getRequestURL());
        Enumeration<String> enumeration = request.getParameterNames();
        logger.error("请求参数");
        while (enumeration.hasMoreElements()){
            String param = enumeration.nextElement().toString();
            logger.error(param+"---"+request.getParameter(param));
        }

        StackTraceElement[] error = ex.getStackTrace();
        for (StackTraceElement stackTraceElement : error) {
            logger.error(stackTraceElement.toString());
        }

        printCause(ex.getCause());
        logger.error("***********异常结束*********");
    }



    public void printCause(Throwable cause){
        if (cause!=null){
            logger.error("Cause by:");
            StackTraceElement[] error = cause.getStackTrace();
            if (error.length>0){
                logger.error(error[0].toString());
            }
            printCause(cause.getCause());
        }
    }

}
*/
