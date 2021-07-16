package com.ruoyi.talents.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author:lw
 * @description:
 * @Date: 2021/7/15
 */
@Data
public class MultistageDictionary {

    /** 主键id */
    private Long id;

    /** 父类id */
    private String parentId;

    /** 字典键值 */
    private String dictId;

    /** 字典内容 */
    private String dictValue;

    /**创建时间*/
    private Date createTime;

    /**子集合*/
    private List<MultistageDictionary> dictionaryList;

}
