package com.yy.algorithm.tree;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/18
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        // 还需要对比最顶点的值
        return isBST(root,null,null);
    }

    public boolean isBST(TreeNode root,TreeNode min, TreeNode max){
        if(root == null) return true;
        if(min!=null && root.val <= min.val){
            return false;
        }
        if(max != null && root.val >= max.val){
            return false;
        }
        return isBST(root.left,min,root) && isBST(root.right,root,max);
    }

    public boolean isValidBST2(TreeNode root) {
        // 中序遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        int value = Integer.MIN_VALUE;
        while(!queue.isEmpty() || root != null){
            while(root != null){
                queue.offer(root);
                root = root.left;
            }
            root = queue.poll();
            // 不是升序排列
            if(root.val < value){
                return false;
            }
            value = root.val;
            root = root.right;
        }
        // 还需要对比最顶点的值
        return true;
    }


    @Test
    public void testBST(){

        TreeNode root = new TreeNode(5);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(7);

        root.left = root2;
        root.right = root3;
        root3.left = root4;
        root3.right = root5;

        System.out.println(isValidBST(root));
        System.out.println(isValidBST(null));

    }


    @Test
    public void testBSTMiddle(){
        TreeNode root = new TreeNode(5);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(7);

        root.left = root2;
        root.right = root3;
        root3.left = root4;
        root3.right = root5;

        System.out.println(isValidBST2(root));
        System.out.println(isValidBST2(null));
    }


}
