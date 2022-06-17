package com.lz.pretty.module.system.service;

import com.lz.pretty.common.constant.CustomExceptionType;
import com.lz.pretty.common.exception.CustomException;
import com.lz.pretty.common.utils.DataTreeUtil;
import com.lz.pretty.module.system.mapper.MySystemMapper;
import com.lz.pretty.module.system.model.SysOrg;
import com.lz.pretty.module.system.model.SysOrgNode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysOrgService {

    @Autowired
    private MySystemMapper systemMapper;

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
            // 否则返回树型结构列表
            return DataTreeUtil.buildTree(sysOrgNodes, rootOrgId);
        } else {
            // 根据组织名称查询，返回平面列表
            return sysOrgNodes;
        }
    }
}
