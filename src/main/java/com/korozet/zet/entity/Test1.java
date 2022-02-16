package com.korozet.zet.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;

/**
 * @author korozet1
 * @date 2021/12/17 10:09
 */

@Data
@Controller
@ConfigurationProperties(
        prefix = "view.test"
)
public class Test1 {
    private Integer id;
}
