package io.dnlwjtud.myBlog.posts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Post {

    // 번호
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    // 제목
    private String title;


    // 내용
    @Setter
    @Column(columnDefinition = "TEXT")
    private String body;

    // 차후
    // 누가 썼는지

    // 언제 썼는지
    private LocalDateTime createdAt;
    // 언제 수정되었는지
    private LocalDateTime updatedAt;

    public static Post createPost(String title, String body, LocalDateTime createdAt, LocalDateTime updatedAt ) {

        Post post = new Post();

        post.title = title;
        post.body = body;

        post.createdAt = createdAt;
        post.updatedAt = updatedAt;

        return post;

    }

}
