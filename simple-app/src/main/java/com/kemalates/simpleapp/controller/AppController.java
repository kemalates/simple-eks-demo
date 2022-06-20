package com.kemalates.simpleapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor
public class AppController {

    @PostMapping ("/echo")
    public ResponseEntity<String> echo(@RequestBody String text) {
        log.debug("echo method called");
        HttpStatus status;
        if (text.isEmpty()) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(text, status);
    }
}
