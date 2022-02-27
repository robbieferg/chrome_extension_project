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
    @JoinColumn(name = "web_page_id", nullable = false)
    private WebPage webPage;

    public Vote(boolean isUpVote, WebPage webPage) {
        this.isUpVote = isUpVote;
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


    public WebPage getWebPage() {
        return webPage;
    }

    public void setWebPage(WebPage webPage) {
        this.webPage = webPage;
    }
}
