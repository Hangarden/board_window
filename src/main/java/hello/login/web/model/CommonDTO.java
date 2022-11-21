package hello.login.web.model;


import hello.login.web.paging.Pagination;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommonDTO extends SearchDto {

    /** 페이징 정보 */
    private Pagination paginationInfo;

    /** 삭제 여부 */
    private String deleteYn;

    /** 등록일 */
    private LocalDateTime insertTime;

    /** 수정일 */
    private LocalDateTime updateTime;

    /** 삭제일 */
    private LocalDateTime deleteTime;

}
