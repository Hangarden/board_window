package hello.login.web.posts.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PostsUpdateRequestDto {

    private Long id;

    private String author;

    private String title;
    private String content;
    private int view;



//    @Builder
//    public PostsUpdateRequestDto(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
}