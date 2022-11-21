package hello.login;


import hello.login.web.comment.CommentService;
import hello.login.web.model.CommentDTO;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CommentTests {

    @Autowired
    private CommentService commentService;


    @Test
    public void registerComments() {
        int number = 3;

        for (int i = 1; i <= number; i++) {
            CommentDTO params = new CommentDTO();
            params.setBoardIdx((long) 1); // 댓글을 추가할 게시글 번호
            params.setContent(i + "번 댓글을 추가합니다!");
            params.setWriter(i + "번 회원");
            commentService.registerComment(params);
        }


    }

    @Test
    public void deleteComment() {
        commentService.deleteComment((long) 10); // 삭제할 댓글 번호

        getCommentList();
    }

    @Test
    public void getCommentList() {
        CommentDTO params = new CommentDTO();
        params.setBoardIdx((long) 1); // 댓글을 추가할 게시글 번호

        commentService.getCommentList(params);
    }

}
