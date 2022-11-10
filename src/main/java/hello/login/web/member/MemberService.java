package hello.login.web.member;

//import hello.login.domain.member.MemberVO;
//import hello.login.domain.member.MemberRepository;
import hello.login.web.mapper.MemberMapper;
import hello.login.web.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

//    private final MemberRepository memberRepository;

    private final MemberMapper mapper;


    public int idCheck(String loginId) {
        int cnt = mapper.idCheck(loginId);
        System.out.println("cnt: " + cnt);
        return cnt;
    }

//    public int addMember(MemberCreateForm member) {
//        int result = mapper.addMember(member);
//        return result;
//    }


    /* insert , update는 리턴타입이 int이므로 리턴받지 않고 실행만 할 수 있음*/
    public int addMember(Member member) {
        int result = mapper.addMember(member);
        return result;
    }


//    public int numberCheck(String phoneNumber) {
//        int cnt = mapper.numberCheck(phoneNumber);
//        System.out.println("cnt: " + cnt);
//        return cnt;
//    }


//    @Transactional
//    public Long save(MemberCreateForm createForm) {
//        return memberRepository.save(createForm.toEntity()).getMemberKey();
//    }

//    public Long save(Member member) {
//        return memberRepository.save(member).getKey();
//    }
//    @Transactional
//    public MemberVO findById(Long id) {
//        MemberVO memberVO = memberRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
//
//        return memberVO;
//    }
//    @Transactional
//    public Optional<MemberVO> findByLoginId(String loginId) {
//        return memberRepository.findAll().stream().filter(m -> m.getLoginId().equals(loginId)).findFirst();
//    }


//    @Transactional(readOnly = true)
//    public List<Member> findAllDesc() {
//        return memberRepository.findAllDesc().stream()
//                .map(Member::new)
//                .collect(Collectors.toList());
//        }


}

