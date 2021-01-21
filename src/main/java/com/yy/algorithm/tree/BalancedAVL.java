package com.yy.algorithm.tree;

import org.junit.Test;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/21
 */
public class BalancedAVL {


    public boolean isBalanced(TreeNode root) {
        // 如何获取子树的高度
        if(root == null) return true;
        if(!isBalanced(root.left) || !isBalanced(root.right)){
            return false;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        if(Math.abs(left - right) > 1){
            return false;
        }
        return true;
    }

    public int getTreeDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(getTreeDepth(root.left),getTreeDepth(root.right)) + 1;
    }


    // 自底向上
    public boolean isBalanced2(TreeNode root) {
        return getHeight(root)>=0;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }else{
            return Math.max(left, right) + 1;
        }
    }


    @Test
    public void testBalanced(){

        TreeNode root = new TreeNode(3);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);

        root.left = root2;
        root.right = root3;
        root3.left = root4;
        root3.right = root5;

        System.out.println(isBalanced(root));
        System.out.println(isBalanced(null));

    }


    @Test
    public void testBalanced2(){

        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(3);
        TreeNode root6 = new TreeNode(4);
        TreeNode root7 = new TreeNode(4);

        root.left = root2;
        root.right = root3;
        root3.left = root4;
        root3.right = root5;
        root5.left = root6;
        root5.right = root7;

        System.out.println(isBalanced(root));

    }

}
