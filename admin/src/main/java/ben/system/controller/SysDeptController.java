package ben.system.controller;

import ben.common.web.controller.BaseController;
import ben.system.entity.SysDept;
import ben.system.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("depts")
public class SysDeptController extends BaseController<SysDept> {
    @Autowired
    public SysDeptController(SysDeptService service) {
        super(service);
    }
}
