package com.springboot.restapis2.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    
    
    public final String uploadDirectory = "/Users/karanjain/Documents/workspace-spring-tool-suite-4-4.16.1.RELEASE/restapis2/src/main/resources/static/images";
    // Making this upload_dir dynamic
    // public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();

    public boolean uploadFile(MultipartFile file){
        boolean f = false;
        try {
            // InputStream is = file.getInputStream();
            // byte data[] = new byte[is.available()];
            // is.read(data);

            // FileOutputStream fos = new FileOutputStream(uploadDirectory+"/"+file.getOriginalFilename());
            // fos.write(data);
            // fos.flush();
            // fos.close();
            Files.copy(file.getInputStream(),Paths.get(uploadDirectory+File.pathSeparator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
