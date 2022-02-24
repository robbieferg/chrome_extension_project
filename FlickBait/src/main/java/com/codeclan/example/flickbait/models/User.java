package com.codeclan.example.flickbait.models;

import com.codeclan.example.flickbait.repositories.CommentRepository;
import com.codeclan.example.flickbait.repositories.UserRepository;
import com.codeclan.example.flickbait.repositories.VoteRepository;
import com.codeclan.example.flickbait.repositories.WebPageRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "users")
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @JsonIgnoreProperties({"users"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "users_pages_rated",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "web_page_id", nullable = false, updatable = false)}
    )
    private List<WebPage> pagesRated;

    @JsonBackReference
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @JsonBackReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Vote> votes;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.pagesRated = new ArrayList<WebPage>();
        this.comments = new ArrayList<Comment>();
        this.votes = new ArrayList<Vote>();
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nam) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<WebPage> getPagesRated() {
        return pagesRated;
    }

    public void setPagesRated(List<WebPage> pagesRated) {
        this.pagesRated = pagesRated;
    }

    public void addWebPage(WebPage webPage){
        this.pagesRated.add(webPage);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComments(Comment comment){
        this.comments.add(comment);
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public void addVote(Vote vote) {
        this.votes.add(vote);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }




}
