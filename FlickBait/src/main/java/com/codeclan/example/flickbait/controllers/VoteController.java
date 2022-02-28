package com.codeclan.example.flickbait.controllers;

import com.codeclan.example.flickbait.models.Comment;
import com.codeclan.example.flickbait.models.Vote;
import com.codeclan.example.flickbait.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoteController {

    @Autowired
    VoteRepository voteRepository;

    @GetMapping(value = "/votes")
    public ResponseEntity<List<Vote>> getAllVotes() {
        return new ResponseEntity<>(voteRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/votes/webpages")
    public ResponseEntity<List<Vote>> getAllVotesFromWebpage(
            @RequestParam(name = "url") String url
    ) {
        return new ResponseEntity<>(voteRepository.findByWebPageUrl(url), HttpStatus.OK);
    }

    @PostMapping(value = "/votes")
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote) {
        voteRepository.save(vote);

        return new ResponseEntity<>(vote, HttpStatus.CREATED);
    }
}
