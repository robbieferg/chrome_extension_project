package com.codeclan.example.flickbait.controllers;

import com.codeclan.example.flickbait.models.WebPage;
import com.codeclan.example.flickbait.repositories.WebPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/webpages")
    public ResponseEntity<WebPage> createWebPage(@RequestBody WebPage webPage) {
        webPageRepository.save(webPage);
        return new ResponseEntity<>(webPage, HttpStatus.CREATED);
    }

    @PutMapping(value = "/webpages/{id}")
    public ResponseEntity updateWebPageById(@PathVariable Long id, @RequestBody WebPage updatedWebPage){
        WebPage webPageToUpdate = webPageRepository.findById(id).get();
        webPageToUpdate.setVotes(updatedWebPage.getVotes());
        webPageToUpdate.setComments(updatedWebPage.getComments());
        webPageToUpdate.setUpvotes(updatedWebPage.getUpvotes());
        webPageToUpdate.setDownvotes(updatedWebPage.getDownvotes());
        webPageToUpdate.setAverageRating(updatedWebPage.getAverageRating());
        webPageRepository.save(webPageToUpdate);
        return new ResponseEntity<>(webPageToUpdate, HttpStatus.OK);
    }

    @PatchMapping(value = "/webpages/{id}")
    public ResponseEntity<WebPage> updateWebPage(@RequestBody WebPage webPage){
        webPageRepository.save(webPage);
        return new ResponseEntity<>(webPage, HttpStatus.OK);
    }






}
