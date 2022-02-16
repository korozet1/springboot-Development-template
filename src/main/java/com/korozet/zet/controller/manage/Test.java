package com.korozet.zet.controller.manage;

import com.korozet.zet.entity.Test1;
import com.korozet.zet.util.result.R;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author korozet1
 * @date 2021/12/16 16:41
 */
@RestController
@AllArgsConstructor
@RequestMapping("/zet/test" )
@Api(value = "Test", tags = "测试")
public class Test {
    @Resource
    Test1 test1;
    @GetMapping("test")
    public R Test(){
        return  R.ok("需要权限的也进去了"+":"+test1.getId());
    }
}
