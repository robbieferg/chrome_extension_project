package com.codeclan.example.flickbait.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "author")
    private String author;

    @Column(name = "text")
    private String text;

    @Column(name = "date_and_time")
    private Date dateAndTime;

    @JsonIgnoreProperties({"comments"})
    @ManyToOne
    @JoinColumn(name = "web_page_id")
    private WebPage webPage;

    public Comment(String author, String text, WebPage webPage) {
        this.author = author;
        this.text = text;
        this.dateAndTime = new Date();
        this.webPage = webPage;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public WebPage getWebPage() {
        return webPage;
    }

    public void setWebPage(WebPage webPage) {
        this.webPage = webPage;
    }
}
