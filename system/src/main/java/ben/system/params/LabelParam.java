package ben.system.params;

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
public class LabelParam {
    private List<Integer> labelIds;

    public boolean notValid() {
        return CollectionUtil.isEmpty(labelIds);
    }
}
