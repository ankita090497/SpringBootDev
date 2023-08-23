package com.api.book.bootrestbook.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

    // static path
    // public final String UPLOAD_PATH = "E:\\dev-spring-boot\\05-spring-boot-rest-file-upload\\bootrestbook\\src\\main\\resources\\static\\image";

    // get dynamic path
    public final String UPLOAD_PATH = new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {
    }

    public boolean isUploadFile(MultipartFile profile) {

        boolean fileUploadStatus = false;
        try {

            /*// read data from file
            InputStream stream = profile.getInputStream();
            byte data[] = new byte[stream.available()];
            stream.read(data);

            // write data
            FileOutputStream outputStream = new FileOutputStream(UPLOAD_PATH + File.separator + profile.getOriginalFilename());
            outputStream.write(data);

            outputStream.flush();
            outputStream.close();*/

            Files.copy(profile.getInputStream(), Paths.get(UPLOAD_PATH + File.separator + profile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            fileUploadStatus = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUploadStatus;
    }
}
