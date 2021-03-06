package com.codeclan.example.flickbait.components;

import com.codeclan.example.flickbait.models.Comment;
import com.codeclan.example.flickbait.models.Vote;
import com.codeclan.example.flickbait.models.WebPage;
import com.codeclan.example.flickbait.repositories.CommentRepository;
import com.codeclan.example.flickbait.repositories.VoteRepository;
import com.codeclan.example.flickbait.repositories.WebPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CommentRepository commentRepository;

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

        WebPage guardian = new WebPage("www.theguardian.com/uk");
        webPageRepository.save(guardian);

        WebPage mal = new WebPage("myanimelist.net/");
        webPageRepository.save(mal);

        WebPage newGrounds = new WebPage("www.newgrounds.com/");
        webPageRepository.save(newGrounds);

        WebPage stackOverflow = new WebPage("stackoverflow.com/");
        webPageRepository.save(stackOverflow);

        WebPage messenger = new WebPage("messenger.com/");
        webPageRepository.save(messenger);

        Vote jackV1 = new Vote(true, soundCloud);
        voteRepository.save(jackV1);
        soundCloud.addVote(jackV1);
        webPageRepository.save(soundCloud);

        Vote jackV2 = new Vote(false, guardian);
        voteRepository.save(jackV2);
        guardian.addVote(jackV2);
        webPageRepository.save(guardian);

        Vote jackV3 = new Vote(true, mal);
        voteRepository.save(jackV3);
        mal.addVote(jackV3);
        webPageRepository.save(mal);

        Vote jackV4 = new Vote(true, newGrounds);
        voteRepository.save(jackV4);
        newGrounds.addVote(jackV4);
        webPageRepository.save(newGrounds);

        Vote jackV5 = new Vote(true, stackOverflow);
        voteRepository.save(jackV5);
        stackOverflow.addVote(jackV5);
        webPageRepository.save(stackOverflow);

        Vote jackV6 = new Vote(true, messenger);
        voteRepository.save(jackV6);
        messenger.addVote(jackV6);
        webPageRepository.save(messenger);

        Vote tamerV1 = new Vote(true, soundCloud);
        voteRepository.save(tamerV1);
        soundCloud.addVote(tamerV1);
        webPageRepository.save(soundCloud);

        Vote tamerV2 = new Vote(true, guardian);
        voteRepository.save(tamerV2);
        guardian.addVote(tamerV2);
        webPageRepository.save(guardian);

        Vote tamerV3 = new Vote(false, mal);
        voteRepository.save(tamerV3);
        mal.addVote(tamerV3);
        webPageRepository.save(mal);

        Vote tamerV4 = new Vote(true, newGrounds);
        voteRepository.save(tamerV4);
        newGrounds.addVote(tamerV4);
        webPageRepository.save(newGrounds);

        Vote tamerV5 = new Vote(true, stackOverflow);
        voteRepository.save(tamerV5);
        stackOverflow.addVote(tamerV5);
        webPageRepository.save(stackOverflow);

        Vote tamerV6 = new Vote(true, messenger);
        voteRepository.save(tamerV6);
        messenger.addVote(jackV3);
        webPageRepository.save(messenger);

        Vote robbieV1 = new Vote(false, soundCloud);
        voteRepository.save(robbieV1);
        soundCloud.addVote(robbieV1);
        webPageRepository.save(soundCloud);

        Vote robbieV2 = new Vote(true, guardian);
        voteRepository.save(robbieV2);
        guardian.addVote(robbieV2);
        webPageRepository.save(guardian);

        Vote robbieV3 = new Vote(false, mal);
        voteRepository.save(robbieV3);
        mal.addVote(robbieV3);
        webPageRepository.save(mal);

        Vote robbieV4 = new Vote(false, newGrounds);
        voteRepository.save(robbieV4);
        newGrounds.addVote(robbieV4);
        webPageRepository.save(newGrounds);

        Vote robbieV5 = new Vote(true, stackOverflow);
        voteRepository.save(robbieV5);
        stackOverflow.addVote(robbieV5);
        webPageRepository.save(stackOverflow);

        Vote robbieV6 = new Vote(true, messenger);
        voteRepository.save(robbieV6);
        messenger.addVote(robbieV6);
        webPageRepository.save(messenger);

        Vote yvonneV1 = new Vote(false, soundCloud);
        voteRepository.save(yvonneV1);
        soundCloud.addVote(yvonneV1);
        webPageRepository.save(soundCloud);

        Vote yvonneV2 = new Vote(true, guardian);
        voteRepository.save(yvonneV2);
        guardian.addVote(yvonneV2);
        webPageRepository.save(guardian);

        Vote yvonneV3 = new Vote(true, mal);
        voteRepository.save(yvonneV3);
        mal.addVote(yvonneV3);
        webPageRepository.save(mal);

        Vote yvonneV4 = new Vote(false, newGrounds);
        voteRepository.save(yvonneV4);
        newGrounds.addVote(yvonneV4);
        webPageRepository.save(newGrounds);

        Vote yvonneV5 = new Vote(false, stackOverflow);
        voteRepository.save(yvonneV5);
        stackOverflow.addVote(yvonneV5);
        webPageRepository.save(stackOverflow);

        Vote yvonneV6 = new Vote(false, messenger);
        voteRepository.save(yvonneV6);
        messenger.addVote(yvonneV6);
        webPageRepository.save(messenger);

        Vote sarahV1 = new Vote(true, soundCloud);
        voteRepository.save(sarahV1);
        soundCloud.addVote(sarahV1);
        webPageRepository.save(soundCloud);

        Vote sarahV2 = new Vote(false, guardian);
        voteRepository.save(sarahV2);
        guardian.addVote(sarahV2);
        webPageRepository.save(guardian);

        Vote sarahV3 = new Vote(false, mal);
        voteRepository.save(sarahV3);
        mal.addVote(sarahV3);
        webPageRepository.save(mal);

        Vote sarahV4 = new Vote(true, newGrounds);
        voteRepository.save(sarahV4);
        newGrounds.addVote(sarahV4);
        webPageRepository.save(newGrounds);

        Vote sarahV5 = new Vote(false, stackOverflow);
        voteRepository.save(sarahV5);
        stackOverflow.addVote(sarahV5);
        webPageRepository.save(stackOverflow);

        Vote sarahV6 = new Vote(true, messenger);
        voteRepository.save(sarahV6);
        messenger.addVote(sarahV6);
        webPageRepository.save(messenger);

        Comment jackComment1 = new Comment("Did you know that I make music?", "18/02/2022 - 12.01PM", soundCloud);
        commentRepository.save(jackComment1);
        soundCloud.addComment(jackComment1);
        webPageRepository.save(soundCloud);

        Comment tamerComment1 = new Comment("I am not a loser", "22/02/2022 - 15.54PM", guardian);
        commentRepository.save(tamerComment1);
        guardian.addComment(tamerComment1);
        webPageRepository.save(guardian);
    }
}
