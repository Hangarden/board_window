//package hello.login.domain.member;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface MemberRepository extends JpaRepository<MemberVO, Long> {
//    @Query("SELECT m FROM Member m ORDER BY m.memberKey DESC")
//    List<MemberVO> findAllDesc();
//
//}
