package com.filemanager.service;

import org.junit.jupiter.api.Test;

import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryServiceTest {

    private final DirectoryService directoryService = new DirectoryService();

    @Test
    void testCreateDirectory() throws Exception {
        // Creating the directory path
        Path path = Paths.get("testDir");

        // Create directory operation
        directoryService.createDirectory(path);

        // Verifying if the directory was created
        assertTrue(Files.exists(path) && Files.isDirectory(path));

        Files.deleteIfExists(path);
    }

    @Test
    void testDeleteDirectory() throws Exception {
        // Define the directory path and create it
        Path path = Files.createDirectory(Paths.get("testDir"));

        // Perform the delete directory operation
        directoryService.deleteDirectory(path);

        // Verify that the directory was deleted
        assertFalse(Files.exists(path));
    }
}
