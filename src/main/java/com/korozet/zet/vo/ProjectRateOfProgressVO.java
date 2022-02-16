package com.korozet.zet.vo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class ProjectRateOfProgressVO {

    private Integer id;

    private String projectName;

    private Integer needFinishNum;

    private Integer finishNum;

    private Integer noFinishNum;

    private String infoExplain;

}
