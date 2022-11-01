package hello.login.web;

//import hello.login.domain.Posts.PostsRepository;
import hello.login.domain.Posts.Posts;
import hello.login.domain.item.Item;
import hello.login.web.comment.CommentResponseDto;
import hello.login.web.posts.PostsService;
import hello.login.web.posts.dto.PostsListResponseDto;
import hello.login.web.posts.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class
IndexController {

    private final PostsService postsService;


    @GetMapping("/posts")
    public String postsList(Model model) {
        List<PostsListResponseDto> posts = postsService.findAllDesc();
        model.addAttribute("posts", posts);
        return "posts/posts";
    }


    @GetMapping("/posts/save")
    public String addPost(Model model) {
        //로그인 여부 체크
        model.addAttribute("post", new Posts());//s붙이는지 안 붙이는지
        return "posts/addForm";
    }

    @GetMapping("/posts/{postId}")
    public String postDetail(@PathVariable long postId, Model model) {
        //로그인 여부 체크
        PostsResponseDto responseDto = postsService.findById(postId);
        List<CommentResponseDto> comments = responseDto.getComments();

        /* 댓글 관련 */
        if (comments != null && !comments.isEmpty()) {
            model.addAttribute("comments", comments);
        }


        log.info("{} 입니다", responseDto);
        postsService.updateView(postId);
        model.addAttribute("post", responseDto);
        return "posts/post";
    }

    @GetMapping("posts/{postId}/edit")
    public String editForm(@PathVariable Long postId, Model model) {
        PostsResponseDto ResponseDto = postsService.findById(postId);
        model.addAttribute("post", ResponseDto);
        return "posts/editForm";
    }

//    @GetMapping("/posts/{postId}")
//    public String postDetail(@PathVariable long postId, Model model) {
//        //로그인 여부 체크
//        return "items/item";
    }
