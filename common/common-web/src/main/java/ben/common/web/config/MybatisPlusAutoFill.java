package ben.common.web.config;

import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class MybatisPlusAutoFill implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.setFieldValByName("createBy", ReflectUtil.getFieldValue(principal, "userId"), metaObject);
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.setFieldValByName("updateBy", ReflectUtil.getFieldValue(principal, "userId"), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }

}
