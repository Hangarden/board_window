//package hello.login.domain.Posts;
//
//
//import hello.login.domain.comment.Comment;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//import java.util.List;
//
//@NoArgsConstructor
//@Entity
//@Data
//public class Posts {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Size(min=1, message = "한글자 이상은 입력하셔야 합니다")
//    @NotBlank
//    @Column(length = 500)
//    private String title;
//    @Size(min=1, message = "한글자 이상은 입력하셔야 합니다")
//    @NotBlank
//    @Column(columnDefinition = "TEXT")
//    private String content;
//
//    @Column(columnDefinition = "integer default 0", nullable = false)
//    private int view;
//
//    @OneToMany(mappedBy = "posts", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    @OrderBy("id asc") // 댓글 정렬
//    private List<Comment> comments;
//    private String author;
//
//
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "user_id")
////    private User user;
//
//
////    @OneToMany(mappedBy = "posts", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
////    @OrderBy("id asc")
////    private List<Comment> comments;
//
//    @Builder
//    public Posts(String title, String content, String author, Integer view) {
//        this.title = title;
//        this.content = content;
//        this.author = author;
//        this.view = view;
//    }
//
//    public void update(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
//
//    public Posts updateViewCount(Integer view) {
//        this.view = view + 1;
//        return this;
//    }
//
//
//}
