package com.filemanager.ui;

import com.filemanager.service.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class ConsoleUI {
    private final FileService fileService = new FileService();
    private final DirectoryService directoryService = new DirectoryService();
    private final SearchService searchService = new SearchService();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSimple File Manager");
            System.out.println("1. Display Directory Contents");
            System.out.println("2. Copy File");
            System.out.println("3. Move File");
            System.out.println("4. Delete File");
            System.out.println("5. Create Directory");
            System.out.println("6. Delete Directory");
            System.out.println("7. Search Files");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); //

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter directory path: ");
                        Path dirPath = Paths.get(scanner.nextLine());
                        fileService.displayDirectoryContents(dirPath);
                        break;
                    case 2:
                        System.out.print("Enter source file path: ");
                        Path srcPath = Paths.get(scanner.nextLine());
                        System.out.print("Enter target file path: ");
                        Path targetPath = Paths.get(scanner.nextLine());
                        fileService.copyFile(srcPath, targetPath);
                        break;
                    case 3:
                        System.out.print("Enter source file path: ");
                        srcPath = Paths.get(scanner.nextLine());
                        System.out.print("Enter target file path: ");
                        targetPath = Paths.get(scanner.nextLine());
                        fileService.moveFile(srcPath, targetPath);
                        break;
                    case 4:
                        System.out.print("Enter file path to delete: ");
                        Path filePath = Paths.get(scanner.nextLine());
                        fileService.deleteFile(filePath);
                        break;
                    case 5:
                        System.out.print("Enter directory path to create: ");
                        dirPath = Paths.get(scanner.nextLine());
                        directoryService.createDirectory(dirPath);
                        break;
                    case 6:
                        System.out.print("Enter directory path to delete: ");
                        dirPath = Paths.get(scanner.nextLine());
                        directoryService.deleteDirectory(dirPath);
                        break;
                    case 7:
                        System.out.println("1. Search by file name");
                        System.out.println("2. Search by file extension");
                        int searchChoice = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter directory path to search in: ");
                        dirPath = Paths.get(scanner.nextLine());
                        if (searchChoice == 1) {
                            System.out.print("Enter file name: ");
                            String fileName = scanner.nextLine();
                            searchService.searchFilesByName(dirPath, fileName);
                        } else if (searchChoice == 2) {
                            System.out.print("Enter file extension: ");
                            String extension = scanner.nextLine();
                            searchService.searchFilesByExtension(dirPath, extension);
                        }
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }
}

