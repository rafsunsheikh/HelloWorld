/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.utils;

/**
 *
 * @author sagar
 */

import com.ringid.webserver.HTTPServer;
import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShutdownDetection extends Thread {

    private boolean running = false;
    private static long shutdownDetectionInterval = 1000;
    private static File file = new File("shutdown.dat");
    private static final Logger LOG = LogManager.getLogger(ShutdownDetection.class.getSimpleName());

    public ShutdownDetection() {
        running = true;
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e) {
                try {
                    Thread.sleep(shutdownDetectionInterval);
                    file.delete();
                } catch (Exception ex) {
                }
            }
        }
    }

    @Override
    public void run() {
        while (running) {
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Exception e) {
                }
                break;
            }
            try {
                Thread.sleep(shutdownDetectionInterval);
            } catch (Exception e) {
            }
        }

        try {
            HTTPServer.stop();
            Thread.sleep(shutdownDetectionInterval);
            System.out.println("HTTP WEB --> Server Stoped");
        } catch (Exception e) {
            System.err.println("Error closing HTTP WEB --> Server");
        }
    }
}
