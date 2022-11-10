//package hello.login.domain.login;
//
//import hello.login.domain.member.MemberVO;
//import hello.login.web.member.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class LoginService {
//
//    private final MemberService memberService;
//
//    /**
//     * @return null 로그인 실패
//     */
//    public MemberVO login(String loginId, String password) {
//
//        return memberService.findByLoginId(loginId)
//                .filter(m -> m.getPassword().equals(password))
//                .orElse(null);
//    }
//}
