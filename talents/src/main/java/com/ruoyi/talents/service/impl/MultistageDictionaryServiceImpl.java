package com.ruoyi.talents.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.talents.mapper.MultistageDictionaryMapper;
import com.ruoyi.talents.domain.MultistageDictionary;
import com.ruoyi.talents.service.IMultistageDictionaryService;

/**
 * 多级字典Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-16
 */
@Service
public class MultistageDictionaryServiceImpl implements IMultistageDictionaryService {
    @Autowired
    private MultistageDictionaryMapper multistageDictionaryMapper;

    /**
     * 查询多级字典
     * 
     * @param id 多级字典ID
     * @return 多级字典
     */
    @Override
    public MultistageDictionary selectMultistageDictionaryById(Long id)
    {
        return multistageDictionaryMapper.selectMultistageDictionaryById(id+"");
    }

    /**
     * 查询多级字典列表
     * @return 多级字典
     */
    @Override
    public MultistageDictionary selectMultistageDictionaryList(String id) {
        MultistageDictionary dictionary = multistageDictionaryMapper.selectMultistageDictionaryById(id);
        dictionary=recursion(dictionary);
        return dictionary;
    }

    private MultistageDictionary recursion(MultistageDictionary dictionaryFirst){
        String id = dictionaryFirst.getId() + "";
        List<MultistageDictionary> dictionary = multistageDictionaryMapper.selectMultistageDictionary(id);
        if (ObjectUtils.isNotEmpty(dictionary)){
            for (MultistageDictionary md:dictionary) {
                recursion(md);
            }
            dictionaryFirst.setDictionaryList(dictionary);
        }
        return dictionaryFirst;
    }


    /**
     * 新增多级字典
     * 
     * @param multistageDictionary 多级字典
     * @return 结果
     */
    @Override
    public int insertMultistageDictionary(MultistageDictionary multistageDictionary)
    {
        multistageDictionary.setCreateTime(DateUtils.getNowDate());
        return multistageDictionaryMapper.insertMultistageDictionary(multistageDictionary);
    }

    /**
     * 修改多级字典
     * 
     * @param multistageDictionary 多级字典
     * @return 结果
     */
    @Override
    public int updateMultistageDictionary(MultistageDictionary multistageDictionary)
    {
        return multistageDictionaryMapper.updateMultistageDictionary(multistageDictionary);
    }

    /**
     * 批量删除多级字典
     * 
     * @param ids 需要删除的多级字典ID
     * @return 结果
     */
    @Override
    public int deleteMultistageDictionaryByIds(Long[] ids)
    {
        return multistageDictionaryMapper.deleteMultistageDictionaryByIds(ids);
    }

    /**
     * 删除多级字典信息
     * 
     * @param id 多级字典ID
     * @return 结果
     */
    @Override
    public int deleteMultistageDictionaryById(Long id)
    {
        return multistageDictionaryMapper.deleteMultistageDictionaryById(id);
    }
}
