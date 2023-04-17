package io.dnlwjtud.myBlog.posts.service;

import io.dnlwjtud.myBlog.posts.dto.PostUpdateDto;
import io.dnlwjtud.myBlog.posts.dto.PostEditDto;
import io.dnlwjtud.myBlog.posts.dto.PostWriteRequest;
import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public PostEditDto updateById(Long id, PostUpdateDto postUpdateDto) {

        Post findPost = getById(id);

        if ( findPost == null ) {
            return null;
        }

        findPost.update(postUpdateDto);

        return new PostEditDto(findPost.getId());

    }


    @Transactional
    public PostEditDto save(PostWriteRequest postWriteRequest){

        Post savedPost = postRepository.save(Post.createPost(postWriteRequest));

        return new PostEditDto(savedPost.getId());

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
