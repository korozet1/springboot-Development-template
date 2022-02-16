package com.korozet.zet.vo;


import com.korozet.zet.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class RoleInfoVO extends Role {

    private List<MenuVO> menus;
}
