package com.filemanager.service;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileService {
    private static final Logger logger = Logger.getLogger(FileService.class.getName());

    public void copyFile(Path source, Path target) throws IOException {
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            logger.info("File copied from " + source + " to " + target);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to copy file. " + source, e);
            throw e;
        }
    }

    public void moveFile(Path source, Path target) throws IOException {
        try {
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
            logger.info("File moved from " + source + " to " + target);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to move file. " + source, e);
            throw e;
        }
    }

    public void deleteFile(Path path) throws IOException {
        try {
            Files.delete(path);
            logger.info("File deleted! " + path);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to delete file. " + path, e);
            throw e;
        }
    }

    public void displayDirectoryContents(Path dir) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName() + " (Size: " + Files.size(entry) +
                        " bytes, Last Modified: " + Files.getLastModifiedTime(entry) + ")");
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to display directory contents. " + dir, e);
            throw e;
        }
    }
}

