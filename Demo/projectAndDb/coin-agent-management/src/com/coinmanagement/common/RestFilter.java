package com.coinmanagement.common;

import com.coinmanagement.loader.settings.IPLoader;
import com.coinmanagement.utils.ReasonCode;
import com.google.gson.Gson;
import com.ringid.webserver.FilterExecutor;
import com.ringid.webserver.HTTPServer;
import java.util.HashMap;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author RingID Inc.
 */
public class RestFilter extends FilterExecutor {

    private static final Logger LOG = LogManager.getLogger(RestFilter.class.getSimpleName());
    
    @Override
    public boolean execute(HTTPServer.Request request, HTTPServer.Response response) {
        ConcurrentHashMap<Integer, String> map = IPLoader.getInstance().getPermittedIPAddress();
        
        if (map.containsValue(request.getRemoteAddr())) {
            return true;
        }

        LOG.info("IP address --> " + request.getRemoteAddr());
        HashMap<String, Object> responseMap = new HashMap<>(2);
        responseMap.put("sucs", false);
        responseMap.put("mg", ("Unauthorized IP: " + request.getRemoteAddr()));
        responseMap.put("rc", ReasonCode.UNAUTHORIZED_USER);
        response.print(new Gson().toJson(responseMap));
        return false;
    }
}
