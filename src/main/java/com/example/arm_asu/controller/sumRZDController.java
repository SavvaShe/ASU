package com.example.arm_asu.controller;

import com.example.arm_asu.repository.AsuMrNullRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sumRZD")
public class sumRZDController {

    private final AsuMrNullRepository repository;

    @Autowired
    public sumRZDController(AsuMrNullRepository repository) {
        this.repository = repository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getSumRZDAsJson() throws JsonProcessingException {
        String json = repository.sumRZDAsJson();

        return ResponseEntity.ok(json);
    }

}