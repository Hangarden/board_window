package hello.login.web.member;

//import hello.login.domain.member.MemberVO;
import lombok.AllArgsConstructor;
import lombok.Data;

//import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class MemberCreateForm {

    @Size(min=5, message = "ID는 5글자 이상 입력해주세여")
    @NotEmpty
    private String login_Id; //로그인 ID

    @Size(min=2, max=10, message = "이름은 2글자 이상 입력해주세요, 숫자, 특수문자는 사용 불가능 합니다")
    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    @Size(min=8, max=20, message = "8자리 이상 입력하여야 합니다") //https://docs.oracle.com/cd/E56343_01/html/E53930/password-constrain-1.html 참고
    private String password;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String passwordCheck;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Size(max=20)
    private String email1;
    @Size(max=20)
    private String email2;

    @NotEmpty
    @Size(min=5, max = 5)
    private String zipcode;
    @Size(min=5, max = 80)
    private String address1;
    @Size(min=5, max = 80)
    private String address2;


    @NotEmpty
    @Size(min =2, max = 3)
    private String tel1;

    @NotEmpty
    @Size(min =4, max = 5)
    private String tel2;

    @NotEmpty
    @Size(min =4, max = 5)
    private String tel3;

//    public MemberVO toEntity() {
//        return MemberVO.builder()
//                .loginId(loginId)
//                .name(name)
//                .password(password)
//                .email(email1 + "@" + email2)
//                .zip_code(zip_code)
//                .address1(address1)
//                .address2(address2)
//                .phoneNumber(phoneNumber1 + phoneNumber2 + phoneNumber3)
//                .build();
//    }
}

