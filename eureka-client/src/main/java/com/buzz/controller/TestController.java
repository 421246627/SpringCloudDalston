package com.buzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("getNames")
    public List<String> getNames() {
        List<String> lsString = new ArrayList<String>();
        lsString.add("123");
        lsString.add("456");
        lsString.add("789");
        return lsString;
    }
}
