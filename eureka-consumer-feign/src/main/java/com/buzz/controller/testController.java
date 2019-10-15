package com.buzz.controller;

import com.buzz.service.EurekaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    EurekaService eurekaService;

    @GetMapping("/getNames")
    public List<String> getNames() {
        return eurekaService.getNames();
    }
}
