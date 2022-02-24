package com.codeclan.example.flickbait.controllers;

import com.codeclan.example.flickbait.models.WebPage;
import com.codeclan.example.flickbait.repositories.WebPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebPageController {

    @Autowired
    WebPageRepository webPageRepository;

    @GetMapping(value = "/webpages")
    public ResponseEntity<List<WebPage>> getAllWebPages(
            @RequestParam(value = "url", required = false) String url
    ) {
        if (url != null) {
            return new ResponseEntity<>(webPageRepository.findByUrl(url), HttpStatus.OK);
        }
        return new ResponseEntity<>(webPageRepository.findAll(), HttpStatus.OK);
    }


}
