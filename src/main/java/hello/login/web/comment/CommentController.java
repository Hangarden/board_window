package hello.login.web.comment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import hello.login.web.adapter.GsonLocalDateTimeAdapter;
import hello.login.web.model.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @RequestMapping(value = { "/comments", "/comments/{idx}" }, method = { RequestMethod.POST, RequestMethod.PATCH }) //수정시에는 comment/{idx}로 전송
    public JsonObject registerComment(@PathVariable(value = "idx", required = false) Long idx, @RequestBody final CommentDTO params, HttpSession session) {

        JsonObject jsonObj = new JsonObject();

        try {
            if (idx != null) { //idx가 null이 아니라는 것은 댓글번호, PK가 포함되어 있다는 의미, PK가 포함되어 있다는 것은 이미 생성된 댓글임을 의미한다
                params.setIdx(idx);
            }

            Object ob1 = session.getAttribute("NAME");
            String mySessionName = (String)ob1;
            params.setWriter(mySessionName);
            boolean isRegistered = commentService.registerComment(params); //boolean 타입 변수인 isRegistered 에는 CommentService의 registerComment의 메서드의 실행 결과를 저장한다. 실행 된다면 true 아니라면 false를 저장
            jsonObj.addProperty("result", isRegistered); //결과를 result라는 이름의 프로퍼티에 JSON 객체에 추가해서 리턴합니다.

        } catch (DataAccessException e) {
            jsonObj.addProperty("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");  //삭제되었거나, 없는 게시글 번호(boardIdx)를 지정한 상태

        } catch (Exception e) {
            jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
        }

        return jsonObj;
    }


    @GetMapping(value = "/comments/{boardIdx}")
    public JsonObject getCommentList(@PathVariable("boardIdx") Long boardIdx, @ModelAttribute("params") CommentDTO params, Model model) {

        JsonObject jsonObj = new JsonObject();

        List<CommentDTO> commentList = commentService.getCommentList(params);
        if (CollectionUtils.isEmpty(commentList) == false) {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeAdapter()).create();
            JsonArray jsonArr = gson.toJsonTree(commentList).getAsJsonArray();
            jsonObj.add("commentList", jsonArr);
        }

        return jsonObj;
    }

}