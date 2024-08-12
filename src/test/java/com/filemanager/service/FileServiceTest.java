package com.filemanager.service;

import org.junit.jupiter.api.Test;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    private final FileService fileService = new FileService();

    @Test
    void testCopyFile() throws Exception {
        // Creating the source file
        Path source = Files.createTempFile("source", ".txt");
        Files.writeString(source, "Test content");

        // Creating the target file path
        Path target = Paths.get("target.txt");

        // Perform the copy operation
        fileService.copyFile(source, target);

        // Verifying the target file exists and contains the same content
        assertTrue(Files.exists(target));
        assertEquals("Test content", Files.readString(target));

        Files.deleteIfExists(source);
        Files.deleteIfExists(target);
    }

    @Test
    void testMoveFile() throws Exception {
        // Create a temporary source file
        Path source = Files.createTempFile("source", ".txt");
        Files.writeString(source, "Test content");

        // Define the target file path
        Path target = Paths.get("target.txt");

        // Perform the move operation
        fileService.moveFile(source, target);

        // Verifying the source file no longer exists and the target file contains the same content
        assertFalse(Files.exists(source));
        assertTrue(Files.exists(target));
        assertEquals("Test content", Files.readString(target));

        Files.deleteIfExists(target);
    }

    @Test
    void testDeleteFile() throws Exception {
        // Creating a temporary file
        Path path = Files.createTempFile("file", ".txt");

        // Perform the delete operation
        fileService.deleteFile(path);

        // Verifying that the file no longer exists
        assertFalse(Files.exists(path));
    }

    @Test
    void testDisplayDirectoryContents() throws Exception {
        // Creating a directory
        Path dir = Files.createTempDirectory("testDir");

        // Creating a file inside the directory
        Path file = Files.createTempFile(dir, "file", ".txt");

        // Output of the directory contents display
        fileService.displayDirectoryContents(dir);

        Files.deleteIfExists(file);
        Files.deleteIfExists(dir);
    }
}
