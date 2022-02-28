package com.codeclan.example.flickbait.repositories;

import com.codeclan.example.flickbait.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    List<Vote> findByWebPageUrl(String url);
}
