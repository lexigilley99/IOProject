package com.filemanager.service;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.*;

public class LoggingService {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void setupLogging() throws IOException {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        logger.addHandler(ch);

        Path logPath = Paths.get("src/main/resources/log/application.log");
        FileHandler fh = new FileHandler(logPath.toString(), true);
        fh.setLevel(Level.FINE);
        logger.addHandler(fh);

        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }

    public static Logger getLogger() {
        return logger;
    }
}

