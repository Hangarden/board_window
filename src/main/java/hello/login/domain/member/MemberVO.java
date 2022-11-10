//package hello.login.domain.member;
//
////import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
////import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
//
//@Data
//@NoArgsConstructor
//public class MemberVO {
//
//    private Long memberKey;
//
////    @Size(min=5, max=12, message = "ID는 5글자 이상 입력해주세여")
////    @NotEmpty
//    private String loginId; //로그인 ID
//
////    @Size(min=2, max=10, message = "이름은 2글자 이상 입력해주세요, 숫자, 특수문자는 사용 불가능 합니다")
////    @NotEmpty
//    private String name; //사용자 이름
//
////    @Size(min=8, max=20, message = "8자리 이상 입력하여야 합니다") //https://docs.oracle.com/cd/E56343_01/html/E53930/password-constrain-1.html 참고
////    @NotEmpty
//    private String password;
//
////    @Size(max=40)
////    @NotEmpty
//    private String email;
//
////    @Size(min=5, max = 5)
//    private String zip_code;
//
////    @Size(min=5, max = 80)
//    private String address1;
//
////    @Size(min=5, max = 80)
//    private String address2;
//
////    @NotEmpty
////    @Size(min =8, max = 13)
//    private String phoneNumber;
//
//
////    @Builder
////    public MemberVO(String loginId, String name, String password, String email, String zip_code, String address1, String address2, String phoneNumber) {
////        this.loginId = loginId;
////        this.name = name;
////        this.password = password;
////        this.email = email;
////        this.zip_code = zip_code;
////        this.address1 = address1;
////        this.address2 = address2;
////        this.phoneNumber = phoneNumber;
////    }
//
//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Member [loginId=");
//        builder.append(loginId);
//        builder.append(", name=");
//        builder.append(name);
//        builder.append(", password=");
//        builder.append(password);
//        builder.append(", memberLevel=");
//        builder.append(email);
//        builder.append(", email=");
//        builder.append(zip_code);
//        builder.append(", zip_code=");
//        builder.append(address1);
//        builder.append(", address1=");
//        builder.append(address2);
//        builder.append(", address2=");
//        builder.append(phoneNumber);
//        builder.append("]");
//        return builder.toString();
//    }
//}
