package io.dnlwjtud.myBlog.posts.service;

import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    // 1. 포스트 생성  v
    // 2. 포스트 삭제 v
    // 3. 포스트 목록 v
    // 4. 포스트 검색 v
    // 5. 포스트 수정

    @Test
    @DisplayName("포스트 생성 테스트")
    public void postCreateTest(){

        // given -> 포스트 생성에 필요한 정보가 주어졌을 때
//        Post newPost = Post.createPost("title1", "body1");
        // when -> postService.save() 호출하면
        Long savedId = postService.save("title1", "body1");

        // then  -> 정말로 생성이 되는가?
        assertThat(savedId).isEqualTo(1L);

    }

    @Test
    @DisplayName("포스트 삭제 테스트")
    public void removeTest() {

        // given
        Long savedId = postService.save("title1", "body1");

        // when
        postService.removeById(savedId);
        Post findPost = postService.getById(savedId);

        // then
        assertThat(findPost).isNull();
//        assertThat(findPost).isNotNull();

    }

    @Test
    @DisplayName("포스트 목록 테스트")
    public void listTest() {

        // given
        for ( int i = 0; i < 5; i++ ) {
            postService.save("title " + i, "body " + i);
        }

        // when
        List<Post> postList = postService.findAll();

        // then
        assertThat(postList.size()).isEqualTo(5);
//        assertThat(postList.size()).isEqualTo(10);

    }

    @Test
    @DisplayName("포스트 검색 테스트")
    public void searchTest() {

        // given
        for ( int i = 0; i < 10; i++ ) {
            if ( i % 2 == 0 ) {
                postService.save("post " + i, "body " + i);
            }
            postService.save("title " + i, "body " + i);
        }

        // when
        List<Post> post = postService.findAllByTitle("post",
                PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "id"))
        );

        // then
        assertThat(post.size()).isEqualTo(3);

        for (Post post1 : post) {
            System.out.println("post1 = " + post1);

        }

//        assertThat(post.get(0).getTitle()).isEqualTo("post 0");

    }

    @Test
    @DisplayName("게시물 수정 테스트")
    public void updateTest() {

        // given
        postService.save("title1", "body1")

        // when


        // then



    }



}