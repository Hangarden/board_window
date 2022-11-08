package hello.login.web.member;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.web.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final MemberMapper mapper;


    public int idCheck(String loginId) {
        int cnt = mapper.idCheck(loginId);
        System.out.println("cnt: " + cnt);
        return cnt;
    }

    public int numberCheck(String phoneNumber) {
        int cnt = mapper.numberCheck(phoneNumber);
        System.out.println("cnt: " + cnt);
        return cnt;
    }



    @Transactional
    public Long save(MemberCreateForm createForm) {
        return memberRepository.save(createForm.toEntity()).getMemberKey();
    }

//    public Long save(Member member) {
//        return memberRepository.save(member).getKey();
//    }
    @Transactional
    public Member findById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return member;
    }
    @Transactional
    public Optional<Member> findByLoginId(String loginId) {
        return memberRepository.findAll().stream().filter(m -> m.getLoginId().equals(loginId)).findFirst();
    }


//    @Transactional(readOnly = true)
//    public List<Member> findAllDesc() {
//        return memberRepository.findAllDesc().stream()
//                .map(Member::new)
//                .collect(Collectors.toList());
//        }

    }

