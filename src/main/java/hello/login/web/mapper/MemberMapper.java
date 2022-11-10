package hello.login.web.mapper;


import hello.login.web.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int idCheck(String loginId);

    int addMember(Member member);

}
