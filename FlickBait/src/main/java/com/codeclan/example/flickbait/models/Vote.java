package com.codeclan.example.flickbait.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "is_up_vote")
    private boolean isUpVote;

    @JsonIgnoreProperties({"votes"})
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonIgnoreProperties({"votes"})
    @ManyToOne
    @JoinColumn(name = "web_page_id", nullable = false)
    private WebPage webPage;

    public Vote(boolean isUpVote, User user, WebPage webPage) {
        this.isUpVote = isUpVote;
        this.user = user;
        this.webPage = webPage;
    }

    public Vote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isUpVote() {
        return isUpVote;
    }

    public void setUpVote(boolean upVote) {
        isUpVote = upVote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WebPage getWebPage() {
        return webPage;
    }

    public void setWebPage(WebPage webPage) {
        this.webPage = webPage;
    }
}
