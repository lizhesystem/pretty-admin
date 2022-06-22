package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lz.pretty.common.utils.StringUtils;
import com.lz.pretty.module.system.mapper.SysConfigMapper;
import com.lz.pretty.module.system.model.SysConfig;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    public List<SysConfig> getAll(String paramName, String paramDesc) {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(paramName), "param_name", paramName)
                .like(StringUtils.isNotEmpty(paramDesc), "param_desc", paramDesc);

        return sysConfigMapper.selectList(queryWrapper);
    }

    public void updateConfig(SysConfig sysConfig) {
        Assert.isTrue(sysConfig.getId() != null, "修改操作必须带主键");
        sysConfigMapper.updateById(sysConfig);
    }

    public void addConfig(SysConfig sysConfig) {
        sysConfigMapper.insert(sysConfig);
    }

    public void deleteConfig(Long configId) {
        sysConfigMapper.deleteById(configId);
    }
}
