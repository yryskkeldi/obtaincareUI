package com.obtaincare;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    private static Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        logger.error("Logger is configured correctly");
        logger.info("Start the i moving");
        logger.info("Hello");
        logger.warn("Info sad asd");
        System.out.println("Hello World");
    }
}
