package io.dnlwjtud.myBlog.posts.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostUpdateDto {

    @NotBlank
    private String title;

    private String categoryCode;

    private String markdownBody;
    private String htmlBody;

}
