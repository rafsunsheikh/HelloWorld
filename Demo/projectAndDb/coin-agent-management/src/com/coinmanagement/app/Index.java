/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.app;

import com.coinmanagement.common.Session;
import com.ringid.dynamicpage.DynamicPage;
import com.ringid.webserver.HTTP;
import com.ringid.webserver.HTTPServer;
import com.ringid.webserver.utils.Log;
import java.util.HashMap;
import java.util.Map;
import com.coinmanagement.utils.Constants;

/**
 *
 * @author RingID
 */
public class Index extends HTTP {

    private final Log log = new Log("index");
    private final Map<String, String> variables = new HashMap<>();

    @Override
    public void doProcess(HTTPServer.Request request, HTTPServer.Response response) {

        try {
            HTTPServer.Headers respHeaders = response.getHeaders();
            respHeaders.add("Cache-Control", "no-cache, no-store, must-revalidate");

            Session session = (Session) request.getSession().getAttribute(Constants.SESSION);

            if ((session != null) && (session.isLogin())) {
                // Session exist
                response.redirect("dashboard.html", true);

            } else {
                String htmlLink = "/index.html";
                variables.put("status", "hidden");
                variables.put("msg", "");
                DynamicPage.sendResponse(htmlLink, variables, request, response);
            }
        } catch (Exception e) {
            log.error("Exception while reading request", e);
        }

    }

}
