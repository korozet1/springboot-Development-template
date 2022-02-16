package com.korozet.zet.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserVO {
    private String username;

    private String id;

    private List<MenuVO> menus;

    private String mobilePhone;

    private String nickName;

    private String roleName;

    private Integer roleId;
}
