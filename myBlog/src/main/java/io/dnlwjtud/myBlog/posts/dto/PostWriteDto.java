package io.dnlwjtud.myBlog.posts.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostWriteDto {

    private Long postId;

}