package ben.system.vo.note;

import ben.common.web.vo.OrderParam;
import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class NoteListReqVo {
    private String content;
    private List<Integer> labelIds;

    private List<OrderParam> orders = new ArrayList<>();

    public boolean notValid() {
        return !StringUtils.hasText(content) && CollectionUtils.isEmpty(labelIds);
    }

}
