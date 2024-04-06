package com.DmiFinance.BitBlazers.controller;

import com.DmiFinance.BitBlazers.JsonXmlParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {
    private static final String UPLOAD_DIR = "uploads";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }

        try {

            String filename = file.getOriginalFilename();
            String directory = System.getProperty("user.dir") + File.separator + UPLOAD_DIR;
            String filepath = directory + File.separator + filename;

            // Create the directory if it does not exist
            File uploadDir = new File(directory);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Save the file to the local file system
            Path path = Paths.get(filepath);
            Files.write(path, file.getBytes());
            JsonXmlParser.readFiles(String.valueOf(path));

            return ResponseEntity.status(HttpStatus.OK)
                    .body("File uploaded successfully: " + filename);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error uploading file: " + e.getMessage());
        }
    }
}
