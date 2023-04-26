package io.dnlwjtud.myBlog.posts.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostWriteRequest {

    @NotBlank
    private String title;

    private String categoryCode;

    private String htmlBody;
    private String markdownBody;

}
