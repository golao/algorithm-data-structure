package org.golao.com;

import org.golao.com.n2020.TreeNode;

/**
 * 测试工具类
 * 主要功能： 1. 解析输入输出的 TreeNode 结构
 *            2. 解析输入输出的一维数组
 *            3. 二维数组
 *            4. 一维字符串数组
 *            5. 二维字符串数组
 */
public class LeetCodeTestCaseUtil {
    public static TreeNode parseTreeNode(String input){
        return TreeNode.parseStr(input);
    }
    public static String treeNodeToString(TreeNode node){
        return node.toString();
    }

}
