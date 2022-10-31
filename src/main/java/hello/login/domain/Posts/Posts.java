package hello.login.domain.Posts;


import com.fasterxml.jackson.annotation.JsonIgnore;
import hello.login.domain.member.Member;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Entity
@Data
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 500)
    private String title;
    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;

    private String author;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;


//    @OneToMany(mappedBy = "posts", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    @OrderBy("id asc")
//    private List<Comment> comments;

    @Builder
    public Posts(String title, String content, String author, Integer view) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.view = view;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Posts updateViewCount(Integer view) {
        this.view = view + 1;
        return this;
    }


}
