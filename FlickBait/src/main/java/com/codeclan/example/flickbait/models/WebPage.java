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
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "users_pages_rated",
            joinColumns = {@JoinColumn(name = "web_page_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)}

    )
    private List<User> users;

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
        this.users = new ArrayList<User>();
        this.votes = new ArrayList<Vote>();
        this.averageRating = 0.0;
        this.comments = new ArrayList<Comment>();
        this.upvotes = 0;
        this.downvotes = 0;
    }

    public WebPage() {
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
        this.downvotes += 1;
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

    public void addUser(User user) {
        this.users.add(user);
    }
}
