package ben.system.mapper;

import ben.system.entity.Note;
import ben.system.params.NoteQueryIdsParam;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NoteMapper extends BaseMapper<Note> {
    String SQL = """
            select distinct note.note_id from note left join note_label on note.note_id =  note_label.note_id  ${ew.customSqlSegment}
            """;

    @Select(SQL)
    List<Integer> queryNoteIds(@Param(Constants.WRAPPER) Wrapper<NoteQueryIdsParam> query);

    @Select(SQL)
    IPage<Integer> queryNoteIdsByPage(@Param(Constants.WRAPPER) Wrapper<NoteQueryIdsParam> query, Page<Integer> page);

}
