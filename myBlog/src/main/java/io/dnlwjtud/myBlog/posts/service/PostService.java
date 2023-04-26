package io.dnlwjtud.myBlog.posts.service;

import io.dnlwjtud.myBlog.accounts.entity.Account;
import io.dnlwjtud.myBlog.categories.entity.Category;
import io.dnlwjtud.myBlog.categories.service.CategoryService;
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
    private final CategoryService categoryService;

    public List<Post> findAllByTitle(String title, Pageable pageable) {
        List<Post> postList = postRepository.findAllByTitleContaining(title, pageable);
        return postList;

    }

    public List<Post> findAllByCategoryCode(String code) {

        Category findCategory = categoryService.getByCode(code);
        return postRepository.findAllByCategory(findCategory);

    }

    public List<Post> findAllByCategory(Category category) {
        return postRepository.findAllByCategory(category);
    }

    public List<Post> findAll() {
        List<Post> postList = postRepository.findAllByDeleteStatusFalse();
        return postList;
    }

    @Transactional
    public void removeById(Long id) {

        Post findPost = getById(id);

        if ( findPost == null ) {
            return;
        }

        findPost.delete();

    }


    @Transactional
    public PostEditDto updateById(Long id, PostUpdateDto postUpdateDto) {

        Post findPost = getById(id);

        if ( findPost == null ) {
            return null;
        }

        Category findCategory = categoryService.getByCode(postUpdateDto.getCategoryCode());
        findPost.update(postUpdateDto, findCategory);

        return new PostEditDto(findPost.getId());

    }


    @Transactional
    public PostEditDto save(PostWriteRequest postWriteRequest, Account account){

        Post savedPost = postRepository.save(
                Post.createPost(postWriteRequest, account)
        );

        Category findCategory = categoryService.getByCode(postWriteRequest.getCategoryCode());
        savedPost.setCategory(findCategory);

        return new PostEditDto(savedPost.getId());

    }

    public Post getById(Long id) {
        Optional<Post> findPost = postRepository.findById(id);

        if ( findPost.isPresent() ) {
            if ( !findPost.get().isDeleteStatus() ) {
                return findPost.get();
            }
        }

        return null;

    }



}
