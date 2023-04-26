package io.dnlwjtud.myBlog.posts.entity;

import io.dnlwjtud.myBlog.accounts.entity.Account;
import io.dnlwjtud.myBlog.categories.entity.Category;
import io.dnlwjtud.myBlog.posts.dto.PostUpdateDto;
import io.dnlwjtud.myBlog.posts.dto.PostWriteRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
public class Post {

    // 번호
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 제목
    private String title;

    // 내용
    @Column(columnDefinition = "TEXT")
    private String markdownBody;

    @Column(columnDefinition = "TEXT")
    private String htmlBody;

    @ManyToOne
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Account author;

    private boolean deleteStatus = false;
    private LocalDateTime deletedAt;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Post setCategory(Category category) {
        this.category = category;
        category.getPostList().add(this);
        return this;
    }

    public void delete() {
        this.deleteStatus = true;
        this.deletedAt = LocalDateTime.now();
    }

    public void update(PostUpdateDto postUpdateDto) {

        this.title = postUpdateDto.getTitle();

        this.htmlBody =  postUpdateDto.getHtmlBody();
        this.markdownBody = postUpdateDto.getMarkdownBody();

        this.updatedAt = LocalDateTime.now();

    }


    public static Post createPost(PostWriteRequest postWriteRequest, Account account) {

        Post post = new Post();

        post.title = postWriteRequest.getTitle();

        post.author = account;

        post.markdownBody = postWriteRequest.getMarkdownBody();
        post.htmlBody = postWriteRequest.getHtmlBody();

        return post;

    }


}
