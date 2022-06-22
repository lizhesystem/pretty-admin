package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lz.pretty.common.utils.StringUtils;
import com.lz.pretty.module.system.mapper.SysDictMapper;
import com.lz.pretty.module.system.model.SysDict;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;


    /**
     * 查询所有
     */
    public List<SysDict> all() {
        return sysDictMapper.selectList(null);
    }


    /**
     * 根据参数查询
     *
     * @param groupName 分组名称
     * @param groupCode 分组编码
     */
    public List<SysDict> query(String groupName, String groupCode) {
        LambdaQueryWrapper<SysDict> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery
                .like(StringUtils.isNotEmpty(groupName), SysDict::getGroupName, groupName)
                .like(StringUtils.isNotEmpty(groupCode), SysDict::getGroupCode, groupCode);
        return sysDictMapper.selectList(lambdaQuery);
    }

    /**
     * 根据名称或者编码模糊查找（分页）
     *
     * @param groupName 分组名称
     * @param groupCode 分组编码
     * @param itemDesc  字典描述
     * @return 数据字典列表
     */
    public List<SysDict> queryPage(String groupName, String groupCode, String itemDesc) {
        LambdaQueryWrapper<SysDict> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery
                .like(StringUtils.isNotEmpty(groupName), SysDict::getGroupName, groupName)
                .like(StringUtils.isNotEmpty(groupCode), SysDict::getGroupCode, groupCode)
                .like(StringUtils.isNotEmpty(itemDesc), SysDict::getItemDesc, itemDesc);
        return sysDictMapper.selectList(lambdaQuery);
    }

    // 新增数据字典
    public void addDict(SysDict sysDict) {
        sysDictMapper.insert(sysDict);
    }


    // 修改数据字典
    public void update(SysDict sysDict) {
        Assert.isTrue(sysDict.getId() != null, "修改操作必须带主键");
        sysDictMapper.updateById(sysDict);
    }

    // 删除数据字典
    public void delete(Long id) {
        Assert.isTrue(id != null, "删除操作必须带主键");
        sysDictMapper.deleteById(id);
    }
}
