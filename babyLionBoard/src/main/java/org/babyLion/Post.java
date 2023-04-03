package org.babyLion;

import java.time.LocalDate;

public class Post {

    private int id;

    private String title;
    private String body;

    private LocalDate createDate;
    private LocalDate updatedDate;

    public Post(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createDate = LocalDate.now();
        this.updatedDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", createDate=" + createDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

}
