package com.yy.algorithm.tree;

import lombok.Data;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/15
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
