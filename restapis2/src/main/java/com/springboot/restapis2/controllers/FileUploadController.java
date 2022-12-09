package com.springboot.restapis2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.restapis2.helper.FileUploadHelper;

import jakarta.servlet.Servlet;

@RestController
public class FileUploadController {
    
    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/fileUpload")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file){
        try{
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getContentType());
            System.out.println(file.getName());
            System.out.println(file.getSize());
            if(file.isEmpty()){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain a non-empty file");
            }
            //file upload code
            //where to upload the file on server(in this case, the resources/images)
            boolean f = fileUploadHelper.uploadFile(file);
            if(f){
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
            }
            else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not able to upload successfully");
            }

        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }

    }
}
