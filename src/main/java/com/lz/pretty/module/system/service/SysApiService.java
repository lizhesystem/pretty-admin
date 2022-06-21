package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lz.pretty.common.constant.CustomExceptionType;
import com.lz.pretty.common.exception.CustomException;
import com.lz.pretty.common.utils.StringUtils;
import com.lz.pretty.common.utils.tree.DataTreeUtil;
import com.lz.pretty.module.system.mapper.MySystemMapper;
import com.lz.pretty.module.system.mapper.SysApiMapper;
import com.lz.pretty.module.system.mapper.SysRoleApiMapper;
import com.lz.pretty.module.system.model.SysApi;
import com.lz.pretty.module.system.model.SysRoleApi;
import com.lz.pretty.module.system.model.treenode.SysApiNode;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysApiService {

    @Autowired
    private SysApiMapper sysApiMapper;

    @Autowired
    private MySystemMapper mySystemMapper;

    @Autowired
    private SysRoleApiMapper sysRoleApiMapper;

    /**
     * 构造树形api
     *
     * @param apiNameLike
     * @param apiStatus
     * @return
     */
    public List<SysApiNode> getApiTreeById(String apiNameLike, Boolean apiStatus) {

        // 保证数据库里 level=1的根节点只有一个
        SysApi rootSysApi = sysApiMapper.selectOne(new QueryWrapper<SysApi>().eq("level", 1));
        if (rootSysApi != null) {
            Long rootSysApiId = rootSysApi.getId();
            List<SysApi> sysApiList = mySystemMapper.selectApiTree(rootSysApiId, apiNameLike, apiStatus);

            List<SysApiNode> sysApiNodes = sysApiList.stream().map(item -> {
                SysApiNode node = new SysApiNode();
                BeanUtils.copyProperties(item, node);
                return node;
            }).collect(Collectors.toList());

            // 为空代表查询树形列表
            if (StringUtils.isNotEmpty(apiNameLike)) {
                return sysApiNodes;
            } else {
                return DataTreeUtil.buildTree(sysApiNodes, rootSysApiId);
                // 不为空查询列表
            }


        } else {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                    "请先在数据库内为菜单配置一个分类的根节点，level=1");
        }
    }

    public void updateApi(SysApi sysApi) {
        Assert.isTrue(sysApi.getId() != null, "修改操作必须带主键");
        sysApiMapper.updateById(sysApi);

    }

    public void addApi(SysApi sysApi) {
        setApiIdsAndLevel(sysApi);
        sysApi.setIsLeaf(true);

        SysApi parent = new SysApi();
        parent.setId(sysApi.getApiPid());
        parent.setIsLeaf(false);
        sysApiMapper.updateById(parent);

        sysApiMapper.insert(sysApi);
    }


    public void deleteApi(SysApi sysApi) {
        List<SysApi> sysApiList = sysApiMapper.selectList(new QueryWrapper<SysApi>().
                like("api_pids", "[" + sysApi.getId() + "]"));
        if (sysApiList.size() > 0) {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "" +
                    "下级节点存在数据不允许删掉");
        }

        List<SysApi> sysApis = sysApiMapper.selectList(new QueryWrapper<SysApi>().
                like("api_pids", "[" + sysApi.getApiPid() + "]"));

        if (sysApis.size() == 1) {
            SysApi parent = new SysApi();
            parent.setId(sysApi.getApiPid());
            parent.setIsLeaf(true);
            sysApiMapper.updateById(parent);
        }

        sysApiMapper.deleteById(sysApi);
    }

    private void setApiIdsAndLevel(SysApi sysApi) {
        List<SysApi> sysApis = sysApiMapper.selectList(null);
        for (SysApi api : sysApis) {
            if (api.getApiPid().equals(sysApi.getId())) {
                sysApi.setApiPids(api.getApiPids() + "[" + sysApi.getApiPid() + "]");
                sysApi.setLevel(sysApi.getLevel() + 1);
            }
        }
    }

    // 获取某角色勾选的API访问权限
    public List<String> getExpandedKeys() {
        return mySystemMapper.selectApiExpandedKeys();
    }

    // 获取在API分类树中展开的项
    public List<String> getCheckedKeys(Integer roleId) {
        return mySystemMapper.selectApiCheckedKeys(roleId);
    }

    // 保存接口权限,先删再插
    @Transactional
    public void saveCheckedKeys(Long roleId, List<Long> checkedIds) {
        sysRoleApiMapper.delete(new QueryWrapper<SysRoleApi>().eq("role_id", roleId));
        mySystemMapper.insertRoleApiIds(roleId, checkedIds);
    }

}
