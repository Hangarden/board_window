package hello.login.web.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CommentApiController {

    private final CommentService commentService;

    /* CREATE */
    @PostMapping("/posts/{id}/comments")
    public Long commentSave(@PathVariable Long id, @RequestBody CommentRequestDto dto, HttpSession session) {
        String author = (String) session.getAttribute("userName");
        dto.setAuthor(author);

        return commentService.commentSave(id, dto);
    }
}
