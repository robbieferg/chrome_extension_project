package com.codeclan.example.flickbait.components;

import com.codeclan.example.flickbait.models.WebPage;
import com.codeclan.example.flickbait.repositories.CommentRepository;
import com.codeclan.example.flickbait.repositories.UserRepository;
import com.codeclan.example.flickbait.repositories.VoteRepository;
import com.codeclan.example.flickbait.repositories.WebPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    WebPageRepository webPageRepository;

    public DataLoader(){
    }

    public void run(ApplicationArguments args){
        WebPage soundCloud = new WebPage("http://soundcloud.com/kleyna");
        webPageRepository.save(soundCloud);

        WebPage guardian = new WebPage("http://theguardian.com");
        webPageRepository.save(guardian);

        WebPage mal = new WebPage("http://myanimelist.net");
        webPageRepository.save(mal);

        WebPage newGrounds = new WebPage("https://www.newgrounds.com/");
        webPageRepository.save(newGrounds);

        WebPage stackOverflow = new WebPage("http://www.stackoverflow.com");
        webPageRepository.save(stackOverflow);
    }
}
