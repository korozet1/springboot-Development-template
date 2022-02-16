package com.korozet.zet.vo;

import lombok.Data;

@Data
public class ProjectTaskConfigVO {

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 总量
     */
    private Integer finishTotal;

    /**
     * 项目单位
     */
    private String projectUnit;

    /**
     * 作业周期单位
     */
    private String taskUnit;

    /**
     * 需要完成数量
     */
    private Integer needFinishNum;

    private Integer id;

}
