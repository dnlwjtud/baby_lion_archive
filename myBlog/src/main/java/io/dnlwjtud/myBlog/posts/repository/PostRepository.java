package io.dnlwjtud.myBlog.posts.repository;

import io.dnlwjtud.myBlog.posts.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}