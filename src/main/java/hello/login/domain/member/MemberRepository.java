package hello.login.domain.member;

import hello.login.domain.Posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM Member m ORDER BY m.memberKey DESC")
    List<Member> findAllDesc();

}
