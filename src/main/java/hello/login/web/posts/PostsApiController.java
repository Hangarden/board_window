package hello.login.web.posts;

import hello.login.domain.Posts.Posts;
import hello.login.domain.item.Item;
import hello.login.web.posts.dto.PostsResponseDto;
import hello.login.web.posts.dto.PostsSaveRequestDto;
import hello.login.web.posts.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/posts/save")
    public String  addItem(@Validated @ModelAttribute("post") @RequestBody Posts posts, HttpSession session) {
        String author = (String) session.getAttribute("userName");
        posts.setAuthor(author);
        postsService.save(posts);
        return "redirect:/posts";
    }

//    @PutMapping("/api/v1/posts/{id}")
//    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
//        return postsService.update(id, requestDto);
//    }
//
//    @DeleteMapping("/api/v1/posts/{id}")
//    public Long delete(@PathVariable Long id) {
//        postsService.delete(id);
//        return id;
//    }

//    @GetMapping("/api/v1/posts/{id}")
//    public Posts findById(@PathVariable Long id) {
//        return postsService.findById(id);
//    }
}
