package hello.login.web.posts;

import hello.login.domain.Posts.Posts;
//import hello.login.domain.item.Item;
import hello.login.web.item.form.ItemUpdateForm;
import hello.login.web.posts.dto.PostsResponseDto;
import hello.login.web.posts.dto.PostsSaveRequestDto;
import hello.login.web.posts.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;
@Slf4j
@RequiredArgsConstructor
@Controller
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/posts/save")
    public String  addItem(@Validated @ModelAttribute("post") @RequestBody PostsSaveRequestDto saveRequestDto, HttpSession session) {
        String author = (String) session.getAttribute("userName");
        saveRequestDto.setAuthor(author);
        postsService.save(saveRequestDto);
        return "redirect:/posts";
    }
    @PostMapping("posts/{postId}/edit")
    public String edit(@PathVariable Long postId, @Validated @ModelAttribute("post") PostsUpdateRequestDto form) {

//        if (bindingResult.hasErrors()) {
//            log.info("errors={}", bindingResult);
//            return "items/editForm";
//        }

        form.setTitle(form.getTitle());
        form.setContent(form.getContent());
        log.info("{}입니다", form);

        postsService.update(postId, form);
        return "redirect:/posts/{postId}";
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
