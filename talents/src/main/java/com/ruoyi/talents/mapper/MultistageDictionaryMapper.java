package com.ruoyi.talents.mapper;

import java.util.List;
import com.ruoyi.talents.domain.MultistageDictionary;

/**
 * 多级字典Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-16
 */
public interface MultistageDictionaryMapper 
{

    public List<MultistageDictionary> selectMultistageDictionary(String id);

    /**
     * 查询多级字典
     * 
     * @param id 多级字典ID
     * @return 多级字典
     */
    public MultistageDictionary selectMultistageDictionaryById(String id);

    /**
     * 查询多级字典列表
     * 
     * @param multistageDictionary 多级字典
     * @return 多级字典集合
     */
    public List<MultistageDictionary> selectMultistageDictionaryList(MultistageDictionary multistageDictionary);

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
     * 删除多级字典
     * 
     * @param id 多级字典ID
     * @return 结果
     */
    public int deleteMultistageDictionaryById(Long id);

    /**
     * 批量删除多级字典
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMultistageDictionaryByIds(Long[] ids);





    public List<MultistageDictionary> test();

    public List<MultistageDictionary> test2();

    public int update(MultistageDictionary multistageDictionary);
}
