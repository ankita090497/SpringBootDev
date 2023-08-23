package com.api.book.bootrestbook.controller;


import com.api.book.bootrestbook.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper uploadHelper;


    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("profile") MultipartFile profile) {
        System.out.println("File Name : " + profile.getOriginalFilename());
        System.out.println("File Size : " + profile.getSize());
        System.out.println("File Type : " + profile.getContentType());

        // file upload
        try {
            if (profile.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file.");
            }
            if (!profile.getContentType().equals("application/pdf")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only .pdf content type are allowed");
            }

            boolean isFileUplaod = uploadHelper.isUploadFile(profile);
            if (isFileUplaod) {
                return ResponseEntity.ok("File uploaded successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. Try Again !");
    }
}
