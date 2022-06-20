package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lz.pretty.common.constant.CustomExceptionType;
import com.lz.pretty.common.exception.CustomException;
import com.lz.pretty.common.utils.tree.DataTreeUtil;
import com.lz.pretty.module.system.mapper.MySystemMapper;
import com.lz.pretty.module.system.mapper.SysOrgMapper;
import com.lz.pretty.module.system.model.SysOrg;
import com.lz.pretty.module.system.model.node.SysOrgNode;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysOrgService {

    @Resource
    private MySystemMapper systemMapper;

    @Resource
    private SysOrgMapper sysOrgMapper;

    /**
     * 根据当前登录用户所属组织，查询组织树
     *
     * @param rootOrgId   当前登录用户的组织id
     * @param orgNameLike 组织名称参数
     * @param orgStatus   组织状态参数
     * @return 组织列表
     */
    public List<SysOrgNode> getOrgTreeById(Long rootOrgId, String orgNameLike, Boolean orgStatus) {

        if (rootOrgId == null) {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                    "查询参数用户名组织id不能为空");
        }
        List<SysOrg> sysOrgs = systemMapper.selectOrgTree(rootOrgId, orgNameLike, orgStatus);

        // 转换成 SysOrgNode 对象
        List<SysOrgNode> sysOrgNodes = sysOrgs.stream().map(item -> {
            SysOrgNode node = new SysOrgNode();
            BeanUtils.copyProperties(item, node);
            return node;
        }).collect(Collectors.toList());

        if (StringUtils.isEmpty(orgNameLike)) {
            // 返回树型结构列表
            return DataTreeUtil.buildTree(sysOrgNodes, rootOrgId);
        } else {
            // 根据组织名称查询，返回平面列表
            return sysOrgNodes;
        }
    }

    @Transactional
    public void addOrg(SysOrg sysOrg) {
        seOrgIdsAndLevel(sysOrg);
        // 是否最后一级叶子节点
        sysOrg.setIsLeaf(true);

        // 更新父节点为非子节点,是否是最后一级
        SysOrg parent = new SysOrg();
        parent.setId(sysOrg.getOrgPid());
        parent.setIsLeaf(false);
        sysOrgMapper.updateById(parent);

        sysOrg.setStatus(false); // 新增默认节点可用
        sysOrgMapper.insert(sysOrg);
    }


    public void update(SysOrg sysOrg) {
        if (sysOrg.getId() == null) {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "修改操作必须带主键");
        }
        sysOrgMapper.updateById(sysOrg);
    }


    private void seOrgIdsAndLevel(SysOrg child) {
        List<SysOrg> allOrgs = sysOrgMapper.selectList(null);

        // 设置所有的父节点id，使用[],[] 分割
        for (SysOrg sysorg : allOrgs) {
            if (sysorg.getId().equals(child.getOrgPid())) {
                child.setOrgPids(sysorg.getOrgPids() + ",[" + child.getOrgPid() + "]");
                child.setLevel(sysorg.getLevel() + 1);
            }
        }

    }

    public void delete(SysOrg sysOrg) {
        // 查询有多少自己的子集
        List<SysOrg> myChilds = sysOrgMapper.selectList(new QueryWrapper<SysOrg>()
                .like("org_pids", "[" + sysOrg.getId() + "]"));

        if (myChilds.size() > 0) {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                    "下级组织机构存在数据不允许删掉！");
        }

        // 查看父节点下是否只有我一个子节点
        List<SysOrg> myFatherChilds = sysOrgMapper.selectList(new QueryWrapper<SysOrg>()
                .like("org_pids", "[" + sysOrg.getOrgPids() + "]"));

        if (myFatherChilds.size() == 1) {
            // 我的父节点只有我这一个子节点，而我还要被删除，更新父节点为叶子节点
            SysOrg parent = new SysOrg();
            parent.setId(sysOrg.getOrgPid());
            parent.setIsLeaf(true);
            sysOrgMapper.updateById(parent);
        }

        sysOrgMapper.deleteById(sysOrg.getId());
    }

    /**
     * 更新组织机构状态
     *
     * @param orgId
     * @param status
     */
    public void updateStatus(Long orgId, Boolean status) {
        // isTrue是指断言后面的这个表达式的结果是否为TRUE 如果为TRUE断言为真 跳过
        // 为FALSE 拦截
        Assert.isTrue(orgId != null, "修改操作必须带主键");
        SysOrg sysOrg = new SysOrg();
        sysOrg.setId(sysOrg.getId());
        sysOrg.setStatus(status);
        sysOrgMapper.updateById(sysOrg);
    }
}
