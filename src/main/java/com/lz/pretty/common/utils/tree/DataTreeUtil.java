package com.lz.pretty.common.utils.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述:
 *
 * @author Lz on 2022-06-17
 */
public class DataTreeUtil {

    //构造无根树形结构数据，比如系统左侧菜单栏
    public static <ID, T extends DataTree<T, ID>> List<T> buildTreeWithoutRoot(List<T> paramList, ID rootNodeId) {
        List<T> returnList = new ArrayList<T>();
        for (T node : paramList) {//查找根节点
            //从2级节点开始构造
            if (node.getParentId().equals(rootNodeId)) {
                returnList.add(node);
            }
        }
        for (T entry : paramList) {
            toTreeChildren(returnList, entry);
        }
        return returnList;
    }


    /**
     * 生成树方法
     *
     * @param paramsList 要生成树结构的数组
     * @param rootNodeId 根节点
     * @param <T>
     * @return
     */
    public static <ID, T extends DataTree<T, ID>> List<T> buildTree(List<T> paramsList, ID rootNodeId) {
        ArrayList<T> returnList = new ArrayList<>();
        for (T node : paramsList) {
            //从1级节点开始构造
            if (node.getId().equals(rootNodeId)) {
                returnList.add(node);
            }
        }
        for (T entry : paramsList) {
            toTreeChildren(returnList, entry);
        }
        return returnList;

    }

    private static <ID, T extends DataTree<T, ID>> void toTreeChildren(List<T> returnList, T entry) {
        for (T node : returnList) {
            if (entry.getParentId().equals(node.getId())) {
                if (node.getChildren() == null) {
                    node.setChildren(new ArrayList<T>());
                }
                node.getChildren().add(entry);
            }
            if (node.getChildren() != null) {
                toTreeChildren(node.getChildren(), entry);
            }
        }
    }
}
