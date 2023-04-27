package io.dnlwjtud.myBlog.categories.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCurdDto {

    @NotBlank
    private String name;

    @NotBlank
    private String code;

}
