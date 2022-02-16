package com.korozet.zet.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserPageVO {

    private String mobilePhone;

    private String nickName;

    private String username;

    private LocalDateTime createTime;

    private Integer id;

    private Integer status;

    private String roleName;

    private Integer roleId;
}
