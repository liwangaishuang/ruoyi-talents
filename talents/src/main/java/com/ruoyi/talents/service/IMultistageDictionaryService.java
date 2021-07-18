package com.ruoyi.talents.service;

import java.util.List;
import com.ruoyi.talents.domain.MultistageDictionary;

/**
 * 多级字典Service接口
 * 
 * @author ruoyi
 * @date 2021-07-16
 */
public interface IMultistageDictionaryService 
{
    /**
     * 查询多级字典
     * 
     * @param id 多级字典ID
     * @return 多级字典
     */
    public MultistageDictionary selectMultistageDictionaryById(Long id);

    /**
     * 查询多级字典列表
     *
     * @return 多级字典集合
     */
    public MultistageDictionary selectMultistageDictionaryList(String id);

    /**
     * 新增多级字典
     * 
     * @param multistageDictionary 多级字典
     * @return 结果
     */
    public Long insertMultistageDictionary(MultistageDictionary multistageDictionary);

    /**
     * 修改多级字典
     * 
     * @param multistageDictionary 多级字典
     * @return 结果
     */
    public int updateMultistageDictionary(MultistageDictionary multistageDictionary);

    /**
     * 批量删除多级字典
     * 
     * @param ids 需要删除的多级字典ID
     * @return 结果
     */
    public int deleteMultistageDictionaryByIds(Long[] ids);

    /**
     * 删除多级字典信息
     * 
     * @param id 多级字典ID
     * @return 结果
     */
    public int deleteMultistageDictionaryById(Long id);
}
