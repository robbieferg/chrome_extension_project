package com.codeclan.example.flickbait.controllers;

import com.codeclan.example.flickbait.models.Vote;
import com.codeclan.example.flickbait.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoteController {

    @Autowired
    VoteRepository voteRepository;

    @GetMapping(value = "/votes")
    public ResponseEntity<List<Vote>> getAllVotes() {
        return new ResponseEntity<>(voteRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/votes")
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote) {
        voteRepository.save(vote);
        return new ResponseEntity<>(vote, HttpStatus.CREATED);
    }
}
