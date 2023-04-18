package io.dnlwjtud.myBlog.posts.service;
//
import io.dnlwjtud.myBlog.posts.dto.PostEditDto;
import io.dnlwjtud.myBlog.posts.dto.PostWriteRequest;
import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    @Autowired
    PostRepository repository;

    @Test
    @DisplayName("게시물 목록에서 삭제된 것을 제외하고 가져올 수 있는지")
    public void test1() {

        // given
        for ( int i = 0; i < 10; i++ ) {

            PostWriteRequest postWriteRequest = new PostWriteRequest("title" + i, "body" + i, "body" + i);
            postService.save(postWriteRequest);

        }

        // when
        for ( long j = 1; j <= 5; j++ ) {
            postService.removeById(j);
        }


        // then
        List<Post> postList = postService.findAll();
        assertThat(postList.size()).isEqualTo(5);


    }

    @Test
    @Transactional
    public void test2() {

        // given
        PostWriteRequest postWriteRequest1 = new PostWriteRequest("title1" , "body1" , "body1");
        PostWriteRequest postWriteRequest2 = new PostWriteRequest("title1" , "body1" , "body1");

        PostEditDto savedPost1 = postService.save(postWriteRequest1);
        PostEditDto savedPost2 = postService.save(postWriteRequest2);

        // when
        postService.removeById(savedPost1.getPostId());

        repository.flush();

        Post findPost1 = postService.getById(savedPost1.getPostId());
        Post findPost2 = postService.getById(savedPost2.getPostId());


        // then
        assertThat(findPost1).isNull();
        assertThat(findPost2).isNotNull();

    }


}