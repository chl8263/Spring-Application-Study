package me.ewan.springdata.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post2 {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob //more 255
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
