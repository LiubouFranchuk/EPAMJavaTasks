package com.epam.automation.Helpers;



import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogToFile {



    public static void logToFile(Exception e)  {

        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        FileHandler fileHandler;

        try {
            fileHandler = new FileHandler("logs/logs.txt");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.log(Level.SEVERE, e.getMessage(), e);

            // slf4j dependency can also be used instead of java.util for Logger

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        //TODO question - how do I configure logger to put all failed msgs from all places into the log file?

    }
}
