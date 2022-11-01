package hello.login.web.member;

import hello.login.domain.Posts.Posts;
import hello.login.domain.Posts.PostsRepository;
import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.web.posts.dto.PostsListResponseDto;
import hello.login.web.posts.dto.PostsResponseDto;
import hello.login.web.posts.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(Member member) {
        return memberRepository.save(member).getId();
    }

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

        @Transactional(readOnly = true)
        public List<Member> findAllDesc() {
        return memberRepository.findAllDesc().stream()
                .map(Member::new)
                .collect(Collectors.toList());
        }
    }

