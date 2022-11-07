package hello.login.web.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int idCheck(String loginId);

    int numberCheck(String phoneNumber);

}
