package com.lz.pretty.config;

import com.lz.pretty.module.system.mapper.SysConfigMapper;
import com.lz.pretty.module.system.model.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * 类描述: 系统配置
 * 管理系统内全局参数，比如：默认的用户密码，皮肤等配置
 * 核心数据库表为sys_config.
 * 应用启动时一次性加载全部配置到内存，程序内调用getConfigItem(key)获取参*
 *
 * @author Lz on 2022-06-22
 */
@Component
public class DbLoadSysConfig implements CommandLineRunner {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    private List<SysConfig> sysConfigList;


    // 根据Key获取参数值
    public String getConfigItem(String paramKey) {
        Optional<SysConfig> temp = sysConfigList.stream()
                .filter(item -> item.getParamKey().equals(paramKey))
                .findFirst();
        return temp.orElse(new SysConfig()).getParamValue();
    }

    // 应用启动時會執行加载参数配置
    @Override
    public void run(String... args) throws Exception {
        sysConfigList = sysConfigMapper.selectList(null);
    }

    public List<SysConfig> getSysConfigList() {
        sysConfigList = sysConfigMapper.selectList(null);
        return sysConfigList;
    }
}
