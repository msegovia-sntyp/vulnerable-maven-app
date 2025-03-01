package com.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Testing vulnerable dependencies...");

        // Example usage of a vulnerable library (commons-io)
        try {
            File tempFile = new File("test.txt");
            FileUtils.writeStringToFile(tempFile, "This is a test.", "UTF-8");
            System.out.println("File written successfully: " + tempFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example usage of another vulnerable library (jackson-databind)
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = "{\"name\": \"test\"}";
            Object obj = objectMapper.readValue(json, Object.class);
            System.out.println("Parsed JSON: " + obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 
