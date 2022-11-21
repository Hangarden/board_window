package hello.login.web.comment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import hello.login.web.adapter.GsonLocalDateTimeAdapter;
import hello.login.web.model.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

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