package me.ewan.springdata.webDomain;

import javax.persistence.*;

@Entity
public class WebComment {

    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    private WebPost webPost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public WebPost getWebPost() {
        return webPost;
    }

    public void setWebPost(WebPost webPost) {
        this.webPost = webPost;
    }
}
