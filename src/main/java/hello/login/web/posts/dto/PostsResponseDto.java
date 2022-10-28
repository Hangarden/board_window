package hello.login.web.posts.dto;

import hello.login.domain.Posts.Posts;
import hello.login.domain.member.Member;
import lombok.Getter;


@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private Integer view;



    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.view = entity.getView();
//        this.userId = entity.getUser().getId();
//        this.comments = entity.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}