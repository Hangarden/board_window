package hello.login.domain.member;

import hello.login.domain.Posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long memberKey;

    @Size(min=5, message = "ID는 5글자 이상 입력해주세여")
    @NotEmpty
    @Column(name = "loginId")
    private String loginId; //로그인 ID
    @Size(min=2, message = "이름은 2글자 이상 입력해주세요, 숫자, 특수문자는 사용 불가능 합니다")
    @NotEmpty
    @Column(name = "userName")
    private String name; //사용자 이름
    @Size(min=8, message = "비밀번호는 8글자 이상, 한개이상의 대문자, 소문자, 숫자를 사용하여 입력해주세요") //https://docs.oracle.com/cd/E56343_01/html/E53930/password-constrain-1.html 참고
    @NotEmpty
    private String password;

    @Email
    private String email;

    @Size(min=4)
    @NotNull
    private String zip_code;
    private String address1;
    private String address2;

    @Size(min=12, max=15)
    private String phoneNumber;


    @Builder
    public Member(String loginId, String name, String password, String email, String zip_code, String address1, String address2,String phoneNumber) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.zip_code = zip_code;
        this.address1 = address1;
        this.address2 = address2;
        this.phoneNumber = phoneNumber;
    }
}
