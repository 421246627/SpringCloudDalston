package com.buzz;

import com.buzz.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@EnableFeignClients // 开启扫描Spring Cloud Feign客户端的功能
@EnableDiscoveryClient // 注解用来将当前应用加入到服务治理体系中。
@SpringBootApplication
public class ConsumerFeignApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsumerFeignApp.class).web(true).run(args);
    }

    /**
     * 服务消费者,上传文件
     */
    @RestController
    public class UploadController {

        @Autowired
        UploadService uploadService;
        @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public String handleFileUpload(HttpServletResponse response, @RequestPart(value = "file") MultipartFile file) {
            // 解决跨域问题
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Cache-Control","no-cache");
            return uploadService.handleFileUpload(file);
        }
    }
}
