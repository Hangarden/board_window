package hello.login.web;

import hello.login.domain.item.Item;
import hello.login.web.item.form.ItemSaveForm;
import hello.login.web.posts.PostsService;
import hello.login.web.posts.dto.PostsListResponseDto;
import hello.login.web.posts.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springframework.web.bind.annotation.SessionAttribute;

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
        List<PostsListResponseDto> postsListResponseDtoList = postsService.findAllDesc();
        model.addAttribute("posts", postsListResponseDtoList);
        return "items/posts";
    }


    @GetMapping("/posts/save")
    public String addPost(Model model) {
        //로그인 여부 체크
        model.addAttribute("post", new Item());//s붙이는지 안 붙이는지
        return "items/addForm";
    }

}
