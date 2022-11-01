package hello.login.domain.member;

import hello.login.domain.Posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min=5, message = "ID는 5글자 이상 입력해주세여")
    @NotEmpty
    @Column(name = "userId")
    private String loginId; //로그인 ID
    @Size(min=2, message = "이름은 2글자 이상 입력해주세여")
    @NotEmpty
    @Column(name = "userName")
    private String name; //사용자 이름
    @Size(min=5, message = "비밀번호는 5글자 이상 입력해주세여")
    @NotEmpty
    private String password;

    @Builder
    public Member(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }
    public Member(Member entity) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }

}
