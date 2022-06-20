package com.lz.pretty.common.utils.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述:
 *
 * @author Lz on 2022-06-17
 */
public class DataTreeUtil {

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
