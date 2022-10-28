package hello.login.web.posts.dto;

import hello.login.domain.Posts.Posts;
import hello.login.domain.member.Member;
import lombok.Builder;
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


    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .view(0)
                .build();
    }
}