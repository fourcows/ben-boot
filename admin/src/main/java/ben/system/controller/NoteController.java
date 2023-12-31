package ben.system.controller;

import ben.common.web.vo.R;
import ben.system.service.NoteService;
import ben.system.vo.note.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("notes")
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public R<IPage<NoteListResVo>> page(NotePageReqVo vo) {
        return R.ok(noteService.queryPage(vo));
    }

    @GetMapping("list")
    public R<List<NoteListResVo>> list(NoteListReqVo vo) {
        return R.ok(noteService.queryList(vo));
    }

    @GetMapping("{id}")
    public R<NoteDetailResVo> detail(@PathVariable Integer id) {
        return R.ok(noteService.detail(id));
    }

    @PostMapping
    public R<NoteDetailResVo> add(@RequestBody NoteCreateReqVo vo) {
        return R.ok(noteService.add(vo));
    }

    @PutMapping
    public R<NoteDetailResVo> edit(@RequestBody NoteUpdateReqVo vo) {
        return R.ok(noteService.edit(vo));
    }

    @DeleteMapping("{id}")
    public R<?> delete(@PathVariable Integer id) {
        noteService.delete(Collections.singletonList(id));
        return R.ok();
    }
}
