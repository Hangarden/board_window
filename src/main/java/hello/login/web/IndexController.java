package hello.login.web;

import hello.login.domain.Posts.Posts;
//import hello.login.domain.Posts.PostsRepository;
import hello.login.domain.item.Item;
import hello.login.web.posts.PostsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;


    @GetMapping("/posts")
    public String postsList(Model model) {
        List<Posts> posts = postsService.findAll();
        model.addAttribute("posts", posts);
        return "items/posts";
    }


    @GetMapping("/posts/save")
    public String addPost(Model model) {
        //로그인 여부 체크
        model.addAttribute("post", new Item());//s붙이는지 안 붙이는지
        return "items/addForm";
    }

    @GetMapping("/posts/{postId}")
    public String postDetail(@PathVariable long postId, Model model) {
        //로그인 여부 체크
        Posts posts = postsService.findById(postId);
        log.info("{} 입니다", posts);
        model.addAttribute("post", posts);
        return "items/item";
    }
//    @GetMapping("/posts/{postId}")
//    public String postDetail(@PathVariable long postId, Model model) {
//        //로그인 여부 체크
//        return "items/item";
    }
