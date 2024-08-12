package com.filemanager.service;

import org.junit.jupiter.api.Test;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    private final SearchService searchService = new SearchService();

    @Test
    void testSearchFilesByName() throws Exception {
        // Creating a temporary directory
        Path dir = Files.createTempDirectory("testDir");

        // Creating files inside the directory
        Path file1 = Files.createTempFile(dir, "testFile1", ".txt");
        Path file2 = Files.createTempFile(dir, "testFile2", ".txt");

        // Search result for files containing "testFile1"
        List<Path> foundFiles = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*testFile1*")) {
            for (Path entry : stream) {
                foundFiles.add(entry);
            }
        }

        // Perform the search operation
        searchService.searchFilesByName(dir, "testFile1");

        // Verifying the correct file was found
        assertEquals(1, foundFiles.size());
        assertEquals(file1, foundFiles.get(0));

        Files.deleteIfExists(file1);
        Files.deleteIfExists(file2);
        Files.deleteIfExists(dir);
    }

    @Test
    void testSearchFilesByExtension() throws Exception {
        // Creating a temporary directory
        Path dir = Files.createTempDirectory("testDir");

        // Creating files inside the directory
        Path file1 = Files.createTempFile(dir, "testFile1", ".txt");
        Path file2 = Files.createTempFile(dir, "testFile2", ".txt");

        // Search result for files with ".txt" extension
        List<Path> foundFiles = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.txt")) {
            for (Path entry : stream) {
                foundFiles.add(entry);
            }
        }

        // Perform the search operation
        searchService.searchFilesByExtension(dir, "txt");

        // Verifying the correct files were found
        assertEquals(2, foundFiles.size());
        assertTrue(foundFiles.contains(file1) && foundFiles.contains(file2));

        Files.deleteIfExists(file1);
        Files.deleteIfExists(file2);
        Files.deleteIfExists(dir);
    }
}
