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

    @Size(min = 2)
    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    @Size(min = 8)
    private String password;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String passwordCheck;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    private String email1;

    private String email2;

    @NotEmpty
    @Size(min=5, max = 5)
    private String zip_code;
    private String address1;
    private String address2;


    @NotEmpty
    private String phoneNumber1;

    @NotEmpty
    private String phoneNumber2;

    @NotEmpty
    private String phoneNumber3;

    public Member toEntity() {
        return Member.builder()
                .loginId(loginId)
                .name(name)
                .password(password)
                .email(email1 + "@" + email2)
                .zip_code(zip_code)
                .address1(address1)
                .address2(address2)
                .phoneNumber(phoneNumber1 + phoneNumber2 + phoneNumber3)
                .build();
    }
}

