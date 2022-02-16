package com.korozet.zet.dto;

import lombok.Data;

@Data
public class UserPageDTO {

    /**
     * 模糊匹配字段
     */
    private String findField;

    /**
     * 角色id
     */
    private Integer roleId;
}
