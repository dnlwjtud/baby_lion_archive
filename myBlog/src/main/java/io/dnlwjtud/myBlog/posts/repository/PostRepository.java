package io.dnlwjtud.myBlog.posts.repository;

import io.dnlwjtud.myBlog.posts.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByTitleContaining(String title, Pageable pageable);

    List<Post> findAllByDeleteStatusFalse();

    Optional<Post> findByIdAndDeleteStatusFalse(Long id);

}