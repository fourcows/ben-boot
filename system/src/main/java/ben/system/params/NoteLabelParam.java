package ben.system.params;

import ben.common.web.vo.OrderParam;
import cn.hutool.core.collection.CollectionUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteLabelParam {
    private List<Integer> noteIds;
    private List<Integer> labelIds;

    private List<OrderParam> orders;


    public boolean notValid() {
        return CollectionUtil.isEmpty(noteIds) && CollectionUtil.isEmpty(labelIds);
    }
}
