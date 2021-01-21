package com.yy.algorithm.tree;

import org.junit.Test;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/20
 */
public class BSTDeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        // 删除节点 需要将左子树的最右节点替换或者右子树的最左节点
        if(root.val == key){
            // 叶子节点直接删除
            if(root.left == null && root.right == null) return null;
            else if(root.left != null) {
                TreeNode prev = root.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                root.val = prev.val;
                root.left = deleteNode(root.left,prev.val);
            }else if(root.right != null){
                TreeNode after = root.right;
                while(after.left != null){
                    after = after.left;
                }
                root.val = after.val;
                root.right = deleteNode(root.right,after.val);
            }
        }
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        return root;
    }

    @Test
    public void testDeleteNode(){

        TreeNode root = new TreeNode(4);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(7);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(3);

        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;

        System.out.println(new BSTDeleteNode().deleteNode(root,2));
    }

}
