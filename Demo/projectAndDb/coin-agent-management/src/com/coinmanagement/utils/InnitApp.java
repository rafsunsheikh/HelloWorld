/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.utils;

import com.ringid.webserver.HTTPServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author sagar
 */
public class InnitApp {

    private static final Logger LOG = LogManager.getLogger(InnitApp.class.getSimpleName());

    public static void main(String[] args) {
        ShutdownDetection std = new ShutdownDetection();

        std.start();       

        HTTPServer.init(args);

        LOG.info("onStart --> Server Started successfully");

        try {
            std.join();
            System.err.println("## Application Server --> closed");
        } catch (InterruptedException ex) {
            System.exit(0);
        }
    }
}
