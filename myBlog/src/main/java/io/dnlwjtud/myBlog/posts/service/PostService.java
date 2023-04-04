package io.dnlwjtud.myBlog.posts.service;

import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.repository.PostRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 블로그
    // 포스팅 기능
    // CRUD -> 작성 조회 수정 삭제
    //////////////
    // 포스트 작성 v
    // 포스트 수정 v
    // 포스트 목록 v
    // 포스트 검색
    // 포스트 조회 v
    // 포스트 삭제 v
    //////////////

    // 포스트 삭제
    @Transactional
    public void removeById(Long id) {

        // 1. 포스트 객체를 불러온다
        Post findPost = getById(id);

        if ( findPost == null ) {
            return;
        }

        // 2. 삭제
        postRepository.delete(findPost);

    }


    // 포스트 수정
    @Transactional
    public void updateById(Long id, String title, String body) {

        Post findPost = getById(id);

        if ( findPost == null ) {
            return;
        }

        findPost.setTitle(title);
        findPost.setBody(body);

    }


    @Transactional
    public Long save(String title, String body, LocalDateTime createdAt, LocalDateTime updatedAt){
        return postRepository.save(Post.createPost(title,body,createdAt, updatedAt)).getId();
    }

    // 포스트 검색
    public Post getById(Long id) {
        Optional<Post> findPost = postRepository.findById(id);

        if ( findPost.isPresent() ) {
            return findPost.get();
        }

        return null;

    }



}
