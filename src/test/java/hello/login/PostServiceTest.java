package hello.login;

import hello.login.web.model.PostRequest;
import hello.login.web.posts.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void save() {
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        postService.savePost(params);
        Long id = postService.savePost(params);
        System.out.println("생성된 게시글 ID : " + id);
    }

}