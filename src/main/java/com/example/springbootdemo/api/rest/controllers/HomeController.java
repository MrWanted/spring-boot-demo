package com.example.springbootdemo.api.rest.controllers;

import com.example.springbootdemo.api.dto.MyData;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public @ResponseBody String greeting() throws Exception {
         throw new Exception("test exception");
    }
    @PostMapping(value = "/data", consumes = { MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> handleData(@RequestBody MyData data) {
        return ResponseEntity.ok("Data processed successfully");
    }
}
