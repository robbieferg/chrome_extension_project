package com.codeclan.example.flickbait.repositories;

import com.codeclan.example.flickbait.models.WebPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebPageRepository extends JpaRepository<WebPage, Long> {

    List<WebPage> findByUrl(String url);

}
