/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.utils;

import com.ringid.webserver.HTTPServer;
import java.io.IOException;

/**
 *
 * @author Kazi Nasir Uddin Oly
 */
public class ParamRetriever {
    
    public static Integer getIntValueFromParam(HTTPServer.Request request, String parameterName) throws IOException {
        String tempParam = getParamAsString(request, parameterName);
        if(checkNotNull(tempParam)) return Integer.parseInt(tempParam);
        return null;  
    }

    public static Long getLongValueFromParam(HTTPServer.Request request, String parameterName) throws IOException {
        String tempParam = getParamAsString(request, parameterName);
        if(checkNotNull(tempParam)) return Long.parseLong(tempParam);
        return null;  
    }

    public static Double getDoubleValueFromParam(HTTPServer.Request request, String parameterName) throws IOException {
        String tempParam = getParamAsString(request, parameterName);
        if(checkNotNull(tempParam)) return Double.parseDouble(tempParam);
        return null;
    }

    public static String getStringValueFromParam(HTTPServer.Request request, String parameterName) throws IOException {
        return getParamAsString(request, parameterName);
    }

    public static Byte getByteValueFromParam(HTTPServer.Request request, String parameterName) throws IOException {
        String tempParam = getParamAsString(request, parameterName);
        if(checkNotNull(tempParam)) return Byte.parseByte(tempParam);
        return null;
    }
    
    private static String getParamAsString(HTTPServer.Request request, String parameterName) throws IOException {
        return request.getParams().get(parameterName);
    }
    
    private static boolean checkNotNull(String tempParam){
        return tempParam != null && tempParam.length() > 0;
    }
}
