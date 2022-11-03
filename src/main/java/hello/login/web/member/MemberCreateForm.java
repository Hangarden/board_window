package hello.login.web.member;

import hello.login.domain.Posts.Posts;
import hello.login.domain.member.Member;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class MemberCreateForm {

    @Size(min=5, message = "ID는 5글자 이상 입력해주세여")
    @NotEmpty
    private String loginId; //로그인 ID

    @Size(min = 3, max = 25)
    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String passwordCheck;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;

    @Size(min=4)
    @NotNull
    private String zip_code;
    private String address1;
    private String address2;

    @Size(min=12, max=15)
    private String phoneNumber;

    public Member toEntity() {
        return Member.builder()
                .loginId(loginId)
                .name(name)
                .password(password)
                .email(email)
                .zip_code(zip_code)
                .address1(address1)
                .address2(address2)
                .phoneNumber(phoneNumber)
                .build();
    }
}

