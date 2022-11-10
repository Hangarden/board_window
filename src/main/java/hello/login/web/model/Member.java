package hello.login.web.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;


@ToString
@Data
public class Member {

    private String login_id; //로그인 ID
    private String name; //사용자 이름
    private String password;
    private String email1;
    private String email2;
    private String zipcode;
    private String address_one;
    private String address_two;
    private String tel1;
    private String tel2;
    private String tel3;

}
