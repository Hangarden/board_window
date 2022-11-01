package hello.login.web.comment;

import hello.login.domain.Posts.Posts;
import hello.login.domain.Posts.PostsRepository;
import hello.login.domain.comment.Comment;
import hello.login.domain.comment.CommentRepository;
import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final MemberRepository memberRepository;
    private final PostsRepository postsRepository;

    /* CREATE */
    @Transactional
    public Long commentSave(Long id, CommentRequestDto dto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + id));

        dto.setPosts(posts);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return dto.getId();
    }
}
