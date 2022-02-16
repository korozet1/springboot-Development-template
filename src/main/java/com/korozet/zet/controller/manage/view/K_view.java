package com.korozet.zet.controller.manage.view;
import com.korozet.zet.util.result.R;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/view" )
@Api(value = "view", tags = "节点数据配置")

public class K_view {

    @GetMapping("test")
    public R view(){
        return  R.ok("无需权限的也进去了");
    }

}
