package hello.login.web.comment;

import hello.login.domain.Posts.Posts;
import hello.login.domain.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    private Long id;
    private String comment;
//    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
//    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private Posts posts;

    private String author;
    /* Dto -> Entity */
    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(id)
                .comment(comment)
//                .createdDate(createdDate)
//                .modifiedDate(modifiedDate)
                .author(author)
                .posts(posts)
                .build();

        return comments;
    }
}