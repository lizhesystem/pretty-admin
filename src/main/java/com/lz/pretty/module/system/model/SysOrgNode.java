package com.lz.pretty.module.system.model;

import com.lz.pretty.common.utils.DataTree;

import java.util.List;

/**
 * 类描述: 组织机构树对象
 *
 * @author Lz on 2022-06-17
 */

public class SysOrgNode extends SysOrg implements DataTree<SysOrgNode, Long> {

    private List<SysOrgNode> children;


    @Override
    public Long getParentId() {
        return super.getOrgPid();
    }

    @Override
    public void setChildren(List<SysOrgNode> children) {
        this.children = children;
    }

    @Override
    public List<SysOrgNode> getChildren() {
        return this.children;
    }
}
