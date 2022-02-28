package com.codeclan.example.flickbait.controllers;

import com.codeclan.example.flickbait.models.Comment;
import com.codeclan.example.flickbait.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping(value = "/comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/comments/webpages")
    public ResponseEntity<List<Comment>> getAllCommentsFromWebpage(
            @RequestParam(name = "url") String url
    ) {
        return new ResponseEntity<>(commentRepository.findByWebPageUrl(url), HttpStatus.OK);
    }

    @PostMapping(value = "/comments")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
}
