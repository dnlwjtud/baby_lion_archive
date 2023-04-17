package io.dnlwjtud.myBlog.posts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostUpdateDto {

    private Long id;

    private String title;

    private String markdownBody;
    private String htmlBody;

}
