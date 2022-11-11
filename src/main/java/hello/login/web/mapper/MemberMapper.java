package hello.login.web.mapper;


import hello.login.web.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int idCheck(String loginId);

    int addMember(Member member);

    void combineEmail(String email1, String email2);

    void combineTel(String tel1, String tel2, String tel3);

//    Member login(String memberId, String memberPw);

    //회원별 회원정보 조회
    Member selectMember(String memberId);

}
