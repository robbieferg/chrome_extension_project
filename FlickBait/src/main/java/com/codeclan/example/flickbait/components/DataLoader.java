package com.codeclan.example.flickbait.components;

import com.codeclan.example.flickbait.models.Comment;
import com.codeclan.example.flickbait.models.User;
import com.codeclan.example.flickbait.models.Vote;
import com.codeclan.example.flickbait.models.WebPage;
import com.codeclan.example.flickbait.repositories.CommentRepository;
import com.codeclan.example.flickbait.repositories.UserRepository;
import com.codeclan.example.flickbait.repositories.VoteRepository;
import com.codeclan.example.flickbait.repositories.WebPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.GregorianCalendar;

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

        Date date = new Date();

        WebPage soundCloud = new WebPage("soundcloud.com/kleyna");
        webPageRepository.save(soundCloud);

        WebPage guardian = new WebPage("theguardian.com/uk");
        webPageRepository.save(guardian);

        WebPage mal = new WebPage("myanimelist.net/");
        webPageRepository.save(mal);

        WebPage newGrounds = new WebPage("newgrounds.com/");
        webPageRepository.save(newGrounds);

        WebPage stackOverflow = new WebPage("stackoverflow.com/");
        webPageRepository.save(stackOverflow);

        WebPage messenger = new WebPage("messenger.com/");
        webPageRepository.save(messenger);

        User jack = new User("Jack", "jackcogan97@yahoo.co.uk");
        userRepository.save(jack);

        User tamer = new User("Tamer", "tameramer@gmail.com");
        userRepository.save(tamer);

        User robbie = new User("Robbie", "robferg18@codeclan.net");
        userRepository.save(robbie);

        User yvonne = new User("Yvonne", "yvonneallen@gmail.com");
        userRepository.save(yvonne);

        User sarah = new User("Sarah", "sarahlouise@hotmail.co.uk");
        userRepository.save(sarah);

        Vote jackV1 = new Vote(true, jack, soundCloud);
        voteRepository.save(jackV1);
        jack.addVote(jackV1);
        userRepository.save(jack);
        soundCloud.addVote(jackV1);
        webPageRepository.save(soundCloud);

        Vote jackV2 = new Vote(false, jack, guardian);
        voteRepository.save(jackV2);
        jack.addVote(jackV2);
        userRepository.save(jack);
        guardian.addVote(jackV2);
        webPageRepository.save(guardian);

        Vote jackV3 = new Vote(true, jack, mal);
        voteRepository.save(jackV3);
        jack.addVote(jackV3);
        userRepository.save(jack);
        mal.addVote(jackV3);
        webPageRepository.save(mal);

        Vote jackV4 = new Vote(true, jack, newGrounds);
        voteRepository.save(jackV4);
        jack.addVote(jackV4);
        userRepository.save(jack);
        newGrounds.addVote(jackV4);
        webPageRepository.save(newGrounds);

        Vote jackV5 = new Vote(true, jack, stackOverflow);
        voteRepository.save(jackV5);
        jack.addVote(jackV5);
        userRepository.save(jack);
        stackOverflow.addVote(jackV5);
        webPageRepository.save(stackOverflow);

        Vote jackV6 = new Vote(true, jack, messenger);
        voteRepository.save(jackV6);
        jack.addVote(jackV6);
        userRepository.save(jack);
        messenger.addVote(jackV6);
        webPageRepository.save(messenger);

        Vote tamerV1 = new Vote(true, tamer, soundCloud);
        voteRepository.save(tamerV1);
        tamer.addVote(tamerV1);
        userRepository.save(tamer);
        soundCloud.addVote(tamerV1);
        webPageRepository.save(soundCloud);

        Vote tamerV2 = new Vote(true, tamer, guardian);
        voteRepository.save(tamerV2);
        tamer.addVote(tamerV2);
        userRepository.save(tamer);
        guardian.addVote(tamerV2);
        webPageRepository.save(guardian);

        Vote tamerV3 = new Vote(false, tamer, mal);
        voteRepository.save(tamerV3);
        tamer.addVote(tamerV3);
        userRepository.save(tamer);
        mal.addVote(tamerV3);
        webPageRepository.save(mal);

        Vote tamerV4 = new Vote(true, tamer, newGrounds);
        voteRepository.save(tamerV4);
        tamer.addVote(tamerV4);
        userRepository.save(tamer);
        newGrounds.addVote(tamerV4);
        webPageRepository.save(newGrounds);

        Vote tamerV5 = new Vote(true, tamer, stackOverflow);
        voteRepository.save(tamerV5);
        tamer.addVote(tamerV5);
        userRepository.save(tamer);
        stackOverflow.addVote(tamerV5);
        webPageRepository.save(stackOverflow);

        Vote tamerV6 = new Vote(true, tamer, messenger);
        voteRepository.save(tamerV6);
        tamer.addVote(tamerV6);
        userRepository.save(tamer);
        messenger.addVote(jackV3);
        webPageRepository.save(messenger);

        Vote robbieV1 = new Vote(false, robbie, soundCloud);
        voteRepository.save(robbieV1);
        robbie.addVote(robbieV1);
        userRepository.save(robbie);
        soundCloud.addVote(robbieV1);
        webPageRepository.save(soundCloud);

        Vote robbieV2 = new Vote(true, robbie, guardian);
        voteRepository.save(robbieV2);
        robbie.addVote(robbieV2);
        userRepository.save(robbie);
        guardian.addVote(robbieV2);
        webPageRepository.save(guardian);

        Vote robbieV3 = new Vote(false, robbie, mal);
        voteRepository.save(robbieV3);
        robbie.addVote(robbieV3);
        userRepository.save(robbie);
        mal.addVote(robbieV3);
        webPageRepository.save(mal);

        Vote robbieV4 = new Vote(false, robbie, newGrounds);
        voteRepository.save(robbieV4);
        robbie.addVote(robbieV4);
        userRepository.save(robbie);
        newGrounds.addVote(robbieV4);
        webPageRepository.save(newGrounds);

        Vote robbieV5 = new Vote(true, robbie, stackOverflow);
        voteRepository.save(robbieV5);
        robbie.addVote(robbieV5);
        userRepository.save(robbie);
        stackOverflow.addVote(robbieV5);
        webPageRepository.save(stackOverflow);

        Vote robbieV6 = new Vote(true, robbie, messenger);
        voteRepository.save(robbieV6);
        robbie.addVote(robbieV6);
        userRepository.save(robbie);
        messenger.addVote(robbieV6);
        webPageRepository.save(messenger);

        Vote yvonneV1 = new Vote(false, yvonne, soundCloud);
        voteRepository.save(yvonneV1);
        yvonne.addVote(yvonneV1);
        userRepository.save(yvonne);
        soundCloud.addVote(yvonneV1);
        webPageRepository.save(soundCloud);

        Vote yvonneV2 = new Vote(true, yvonne, guardian);
        voteRepository.save(yvonneV2);
        yvonne.addVote(yvonneV2);
        userRepository.save(yvonne);
        guardian.addVote(yvonneV2);
        webPageRepository.save(guardian);

        Vote yvonneV3 = new Vote(true, yvonne, mal);
        voteRepository.save(yvonneV3);
        yvonne.addVote(yvonneV3);
        userRepository.save(yvonne);
        mal.addVote(yvonneV3);
        webPageRepository.save(mal);

        Vote yvonneV4 = new Vote(false, yvonne, newGrounds);
        voteRepository.save(yvonneV4);
        yvonne.addVote(yvonneV4);
        userRepository.save(yvonne);
        newGrounds.addVote(yvonneV4);
        webPageRepository.save(newGrounds);

        Vote yvonneV5 = new Vote(false, yvonne, stackOverflow);
        voteRepository.save(yvonneV5);
        yvonne.addVote(yvonneV5);
        userRepository.save(yvonne);
        stackOverflow.addVote(yvonneV5);
        webPageRepository.save(stackOverflow);

        Vote yvonneV6 = new Vote(false, yvonne, messenger);
        voteRepository.save(yvonneV6);
        yvonne.addVote(yvonneV6);
        userRepository.save(yvonne);
        messenger.addVote(yvonneV6);
        webPageRepository.save(messenger);

        Vote sarahV1 = new Vote(true, sarah, soundCloud);
        voteRepository.save(sarahV1);
        sarah.addVote(sarahV1);
        userRepository.save(sarah);
        soundCloud.addVote(sarahV1);
        webPageRepository.save(soundCloud);

        Vote sarahV2 = new Vote(false, sarah, guardian);
        voteRepository.save(sarahV2);
        sarah.addVote(sarahV2);
        userRepository.save(sarah);
        guardian.addVote(sarahV2);
        webPageRepository.save(guardian);

        Vote sarahV3 = new Vote(false, sarah, mal);
        voteRepository.save(sarahV3);
        sarah.addVote(sarahV3);
        userRepository.save(sarah);
        mal.addVote(sarahV3);
        webPageRepository.save(mal);

        Vote sarahV4 = new Vote(true, sarah, newGrounds);
        voteRepository.save(sarahV4);
        sarah.addVote(sarahV4);
        userRepository.save(sarah);
        newGrounds.addVote(sarahV4);
        webPageRepository.save(newGrounds);

        Vote sarahV5 = new Vote(false, sarah, stackOverflow);
        voteRepository.save(sarahV5);
        sarah.addVote(sarahV5);
        userRepository.save(sarah);
        stackOverflow.addVote(sarahV5);
        webPageRepository.save(stackOverflow);

        Vote sarahV6 = new Vote(true, sarah, messenger);
        voteRepository.save(sarahV6);
        sarah.addVote(sarahV6);
        userRepository.save(sarah);
        messenger.addVote(sarahV6);
        webPageRepository.save(messenger);

        Comment jackComment1 = new Comment(jack, "Did you know that I make music?", date, soundCloud);
        commentRepository.save(jackComment1);
        jack.addComment(jackComment1);
        userRepository.save(jack);
        soundCloud.addComment(jackComment1);
        webPageRepository.save(soundCloud);

        Comment tamerComment1 = new Comment(tamer, "I am not a loser", date, guardian);
        commentRepository.save(tamerComment1);
        tamer.addComment(tamerComment1);
        userRepository.save(tamer);
        guardian.addComment(tamerComment1);
        webPageRepository.save(guardian);
    }
}
