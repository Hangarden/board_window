package hello.login.web.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {

    private Long id;             // PK
    private String title;        // 제목
    private String content;      // 내용
    private String writer;       // 작성자

    public void removeTag() {
        this.title = this.title.replaceAll("<", "&lt;");
        this.title = this.title.replaceAll(">", "&gt;");
        this.content = this.content.replaceAll("<", "&lt;");
        this.content = this.content.replaceAll(">", "&gt;");
    }
}
