package com.codeclan.example.flickbait.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import com.codeclan.example.flickbait.components.DataLoader;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "date_and_time")
    private String dateAndTime;

    @JsonIgnoreProperties({"comments"})
    @ManyToOne
    @JoinColumn(name = "web_page_id")
    private WebPage webPage;

    public Comment(String text, String dateAndTime, WebPage webPage) {
        this.text = text;
        this.dateAndTime = dateAndTime;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public WebPage getWebPage() {
        return webPage;
    }

    public void setWebPage(WebPage webPage) {
        this.webPage = webPage;
    }
}
