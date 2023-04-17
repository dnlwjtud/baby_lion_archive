package io.dnlwjtud.myBlog.posts.service;

import io.dnlwjtud.myBlog.posts.dto.PostUpdateDto;
import io.dnlwjtud.myBlog.posts.dto.PostWriteDto;
import io.dnlwjtud.myBlog.posts.dto.PostWriteRequest;
import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.repository.PostRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> findAllByTitle(String title, Pageable pageable) {
        List<Post> postList = postRepository.findAllByTitleContaining(title, pageable);
        return postList;

    }

    public List<Post> findAll() {
        List<Post> postList = postRepository.findAll();
        return postList;
    }

    @Transactional
    public void removeById(Long id) {

        Post findPost = getById(id);

        if ( findPost == null ) {
            return;
        }

        postRepository.delete(findPost);

    }


    // 포스트 수정
    @Transactional
    public void updateById(PostUpdateDto postUpdateDto) {

        Post findPost = getById(postUpdateDto.getId());

        if ( findPost == null ) {
            return;
        }

        findPost.update(postUpdateDto);

    }


    @Transactional
    public PostWriteDto save(PostWriteRequest postWriteRequest){

        Post savedPost = postRepository.save(Post.createPost(postWriteRequest));

        return new PostWriteDto(savedPost.getId());

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
