package com.yy.algorithm.tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/19
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        // 也就是查找值
        if(root == null || root.val == val) return root;
        else if(root.val > val && root.left != null) return searchBST(root.left,val);
        else if(root.val < val && root.right != null) return searchBST(root.right,val);
        return null;
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        // 使用队列
        while(root != null) {
            if (root.val == val) return root;
            else if (root.val > val) root = root.left;
            else if (root.val < val) root = root.right;
        }
        return null;
    }


    @Test
    public void testSearchBST(){

        TreeNode root = new TreeNode(4);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(7);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(3);

        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;

        System.out.println(searchBST(root,2));
        System.out.println(searchBST(root,5));
        System.out.println(searchBST(null,5));
    }

    @Test
    public void testSearchBST2(){

        TreeNode root = new TreeNode(4);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(7);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(3);

        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;

        System.out.println(searchBST2(root,2));
        System.out.println(searchBST2(root,5));
        System.out.println(searchBST2(null,5));
    }

}
