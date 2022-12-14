package hello.login.web.posts;

import hello.login.web.common.MessageDto;
import hello.login.web.model.PostRequest;
import hello.login.web.model.PostResponse;
import hello.login.web.model.SearchDto;
import hello.login.web.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성 페이지
    // 게시글 작성 페이지
    @GetMapping("/posts/write.do")
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model, HttpSession session) {
        if (id != null) {
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
//            Object ob1 = session.getAttribute("NAME");
//            String mySessionName = (String)ob1;
//            model.addAttribute("name", mySessionName);
        }
        return "posts/write";
    }

    // 신규 게시글 생성
    @PostMapping("/posts/save.do")
    public String savePost(final PostRequest params, HttpSession session, Model model) {
            params.removeTag();
            Object ob1 = session.getAttribute("NAME");
            String mySessionName = (String)ob1;
            params.setWriter(mySessionName);
            Object ob2 = session.getAttribute("MEMBER_ID");
            Integer mySessionId = (Integer)ob2;
            params.setMemberKey(mySessionId);
            postService.savePost(params);
            MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 리스트 페이지
    @GetMapping("/post/list.do")
    public String openPostList(@ModelAttribute("params") final SearchDto params, Model model) {
        PagingResponse<PostResponse> response = postService.findAllPost(params);
        model.addAttribute("response", response);
        return "posts/list";
    }

    // 게시글 상세 페이지
    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam Long id, Model model, HttpSession session) {
        PostResponse post = postService.findPostById(id);
        post.setViewCnt(postService.updateCnt(id));
        Object ob2 = session.getAttribute("MEMBER_ID");
        Integer mySessionId = (Integer)ob2;
        Object ob1 = session.getAttribute("NAME");
        String mySessionName = (String)ob1;
        model.addAttribute("memberName", mySessionName);
        model.addAttribute("memberCheck", mySessionId);
        model.addAttribute("post", post);
        return "posts/viewModal";
    }

    // 기존 게시글 수정
    @PostMapping("/post/update.do")
    public String updatePost(final PostRequest params, HttpSession session, Model model) {
        Object ob1 = session.getAttribute("NAME");
        String mySessionName = (String)ob1;
        params.setWriter(mySessionName);
        postService.updatePost(params);
        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 삭제
    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final Long id, Model model) {
        postService.deletePost(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return "redirect:/post/list.do";
    }

    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
}