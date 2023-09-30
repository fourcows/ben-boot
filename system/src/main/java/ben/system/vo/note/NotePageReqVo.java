package ben.system.vo.note;

import ben.common.web.vo.OrderParam;
import ben.common.web.vo.PageParam;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NotePageReqVo {
    private String content;
    private List<Integer> labelIds;

    private List<OrderParam> orders = new ArrayList<>();

    private PageParam<?> page;

    public void validPage() {
        if (page == null) {
            throw new RuntimeException("分页参数必传");
        }
        page.valid();
    }

}
