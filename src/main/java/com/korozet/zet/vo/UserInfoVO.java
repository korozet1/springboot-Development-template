package com.korozet.zet.vo;

import com.korozet.zet.entity.User;
import lombok.Data;

@Data
public class UserInfoVO extends User {

    private Integer roleId;
}
