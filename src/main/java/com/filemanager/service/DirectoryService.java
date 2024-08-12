package com.filemanager.service;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirectoryService {
    private static final Logger logger = Logger.getLogger(DirectoryService.class.getName());

    public void createDirectory(Path path) throws IOException {
        try {
            Files.createDirectory(path);
            logger.info("Directory created! " + path);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to create directory. " + path, e);
            throw e;
        }
    }

    public void deleteDirectory(Path path) throws IOException {
        try {
            Files.delete(path);
            logger.info("Directory deleted! " + path);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to delete directory " + path, e);
            throw e;
        }
    }
}

