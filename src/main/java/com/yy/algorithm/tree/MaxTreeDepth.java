package com.yy.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/15
 */
public class MaxTreeDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = 0,right = 0;
        // 怎么求出最大深度，递归左右节点求最大值
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null){
            left = maxDepth(root.left) + 1;
        }
        if(root.right != null){
            right = maxDepth(root.right) + 1;
        }
        return Math.max(left,right);
    }


    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        // 怎么求出最大深度，递归左右节点求最大值
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left,right);
    }


    public int maxDepth3(TreeNode root) {
        if(root==null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0) {
                TreeNode peek = queue.poll();
                if (peek.left != null) {
                    queue.offer(peek.left);
                }
                if (peek.right != null) {
                    queue.offer(peek.right);
                }
                size--;
            }
            depth++;
        }
       return depth;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);

        root.left = root2;
        root.right = root3;
        root2.right = root4;
        root3.left = root5;

        System.out.println(new MaxTreeDepth().maxDepth3(root));
        System.out.println(new MaxTreeDepth().maxDepth3(null));
    }

}
