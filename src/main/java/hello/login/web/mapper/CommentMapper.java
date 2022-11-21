package hello.login.web.mapper;


import hello.login.web.model.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    int insertComment(CommentDTO params);

    CommentDTO selectCommentDetail(Long idx);

    int updateComment(CommentDTO params);

    int deleteComment(Long idx);

    List<CommentDTO> selectCommentList(CommentDTO params);

    int selectCommentTotalCount(CommentDTO params);

}