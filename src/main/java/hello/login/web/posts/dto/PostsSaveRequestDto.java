package hello.login.web.posts.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@Data
public class PostsSaveRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private String author;

    private int view;


//

}