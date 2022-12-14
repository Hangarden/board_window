//package hello.login.web.comment;
//
//import hello.login.domain.comment.Comment;
//import lombok.Getter;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@Getter
//public class CommentResponseDto {
//
//    private Long id;
//    private String comment;
////    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
////    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
//
//    private String author;
//    private Long postsId;
//
//    /* Entity -> Dto*/
//    public CommentResponseDto(Comment comment) {
//        this.id = comment.getId();
//        this.comment = comment.getComment();
////        this.createdDate = comment.getCreatedDate();
////        this.modifiedDate = comment.getModifiedDate();
//        this.author = comment.getAuthor();
//        this.postsId = comment.getPosts().getId();
//    }
//}
