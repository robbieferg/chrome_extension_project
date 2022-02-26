package com.codeclan.example.flickbait.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "web_pages")
public class WebPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;


    @JsonBackReference
    @OneToMany(mappedBy = "webPage", fetch = FetchType.LAZY)
    private List<Vote> votes;

    @Column(name = "average_rating")
    private double averageRating;

    @JsonBackReference
    @OneToMany(mappedBy = "webPage", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Column(name = "upvotes")
    private int upvotes;

    @Column(name = "downvotes")
    private int downvotes;

    public WebPage(String url) {
        this.url = url;
        this.votes = new ArrayList<Vote>();
        this.averageRating = 0.0;
        this.comments = new ArrayList<Comment>();
        this.upvotes = 0;
        this.downvotes = 0;
    }

    public WebPage() {
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getNumberOfVotes() {
        return this.getVotes().size();
    }

    public void addVote(Vote vote) {
        this.votes.add(vote);
        if (vote.isUpVote() == true) {
            this.upvotes += 1;
        }
        else {
            this.downvotes += 1;
        }

    }

    public double calculateAverageRating() {
        int totalVotes = this.getNumberOfVotes();
        return this.upvotes / totalVotes;
    }

    public int getNumberOfComments(Comment comment) {
        return this.getComments().size();
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }


}
