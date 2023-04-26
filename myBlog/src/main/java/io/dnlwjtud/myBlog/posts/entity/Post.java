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

    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private boolean deleteStatus = false;
    private LocalDateTime deletedAt;

    // 언제 썼는지
    private LocalDateTime createdAt = LocalDateTime.now();
    // 언제 수정되었는지
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

        post.account = account;

        post.markdownBody = postWriteRequest.getMarkdownBody();
        post.htmlBody = postWriteRequest.getHtmlBody();

        return post;

    }


}
