package io.dnlwjtud.myBlog.posts.service;

import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.repository.PostRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 블로그
    // 포스팅 기능
    //////////////
    // 포스트 작성 v
    // 포스트 수정
    // 포스트 목록
    // 포스트 검색
    // 포스트 조회
    // 포스트 삭제
    //////////////

    @Transactional
    public Long save(String title, String body, LocalDateTime createdAt, LocalDateTime updatedAt){
        return postRepository.save(Post.createPost(title,body,createdAt, updatedAt)).getId();
    }




}
