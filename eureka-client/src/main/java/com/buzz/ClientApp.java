package com.buzz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@EnableDiscoveryClient
@SpringBootApplication
/**
 * 服务提供者
 */
public class ClientApp {

    /**
     * 服务提供方,上传文件(接受文件)
     */
    @RestController
    public class UploadController {

        @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public String handleFileUpload(@RequestPart(value = "file")MultipartFile file) {
            return file.getName();
        }
    }
    public static void main(String[] args) {
        new SpringApplicationBuilder(ClientApp.class).web(true).run(args);
    }
}
