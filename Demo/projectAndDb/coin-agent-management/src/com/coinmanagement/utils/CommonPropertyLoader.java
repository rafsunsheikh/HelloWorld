/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author ipvision
 */
public class CommonPropertyLoader {

    private static final Logger LOG = LogManager.getLogger(CommonPropertyLoader.class.getSimpleName());

    private static final String CONFIG_FILE = "/DBConfig.txt";
    private static final String CASSANDRA_ENABLED = "cassandraEnabled";
    private Boolean cassandraEnabled = false;
    private static final String TEST_FLIGHT_USER_RESTRICTED = "testFlightUserRestricted";
    private static final String SERVER_ID = "serverId";
    private static final String NO_OF_TX_CACHE = "noOfTransactionInCache";
    private int serverId = 1;
    private int noOfTransactionInCache = 20;
    private Boolean testFlightUserRestricted = false;

    private static final Properties DB_PROP = new Properties();

    private static CommonPropertyLoader instance;

    public CommonPropertyLoader() {
        loadProperties();
    }

    public static CommonPropertyLoader getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new CommonPropertyLoader();
        }
    }

    private static InputStream loadInputStreamFromFile() throws FileNotFoundException, IOException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        InputStream inputStream = null;
        File file = new File(s + CONFIG_FILE);

        if (file.exists()) {
            inputStream = new FileInputStream(file);
        }
        return inputStream;
    }

    private void loadProperties() {
        LOG.info("Loading common properties");
        InputStream inputStream;
        try {
            inputStream = loadInputStreamFromFile();
            if (inputStream != null) {
                DB_PROP.load(inputStream);
                inputStream.close();
                if (DB_PROP.containsKey(CASSANDRA_ENABLED)) {
                    cassandraEnabled = Boolean.parseBoolean(DB_PROP.getProperty(CASSANDRA_ENABLED));
                } else {
                    LOG.debug("No cassandraEnabled is found in DBConfig.txt");
                }

                if (DB_PROP.containsKey(TEST_FLIGHT_USER_RESTRICTED)) {
                    testFlightUserRestricted = Boolean.parseBoolean(DB_PROP.getProperty(TEST_FLIGHT_USER_RESTRICTED));
                } else {
                    LOG.debug("No testFlightUserRestricted is found in DBConfig.txt");
                }

                if (DB_PROP.containsKey(SERVER_ID)) {
                    serverId = Integer.parseInt(DB_PROP.getProperty(SERVER_ID));
                } else {
                    LOG.debug("Server Id not found in DBConfig.txt");
                }

                if (DB_PROP.containsKey(NO_OF_TX_CACHE)) {
                    noOfTransactionInCache = Integer.parseInt(DB_PROP.getProperty(NO_OF_TX_CACHE));
                    LOG.info("noOfTransactionInCache is "+noOfTransactionInCache);
                } else {
                    LOG.debug("Server Id not found in DBConfig.txt");
                }
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(CommonPropertyLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Boolean getCassandraEnabled() {
        return this.cassandraEnabled;
    }

    public void setCassandraEnabled(Boolean cassandraEnabled) {
        this.cassandraEnabled = cassandraEnabled;
    }

    public Boolean getTestFlightUserRestricted() {
        return testFlightUserRestricted;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public int getNoOfTransactionInCache() {
        return noOfTransactionInCache;
    }

    public void setNoOfTransactionInCache(int noOfTransactionInCache) {
        this.noOfTransactionInCache = noOfTransactionInCache;
    }    
}
