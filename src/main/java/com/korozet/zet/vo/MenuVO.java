package com.korozet.zet.vo;

import lombok.Data;

@Data
public class MenuVO {

    private String url;

    private String menuName;

    private Integer sort;

    private String icon;

    private Integer parentId;

    private Integer menuId;
}
