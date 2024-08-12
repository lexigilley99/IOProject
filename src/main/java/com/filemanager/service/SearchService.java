package com.filemanager.service;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchService {
    private static final Logger logger = Logger.getLogger(SearchService.class.getName());

    public void searchFilesByName(Path dir, String fileName) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*" + fileName + "*")) {
            for (Path entry : stream) {
                System.out.println("Found: " + entry);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to search files by name. " + fileName, e);
            throw e;
        }
    }

    public void searchFilesByExtension(Path dir, String extension) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*." + extension)) {
            for (Path entry : stream) {
                System.out.println("Found: " + entry);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to search files by extension. " + extension, e);
            throw e;
        }
    }
}

