package com.korozet.zet.dto;

import lombok.Data;

@Data
public class RoleDTO {
    /**
     * id
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 菜单id数组
     */
    private Integer [] menuIds;
}
