package com.yy.algorithm.tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/18
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while(size > 0){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
            results.add(level);
        }
        return results;
    }


    @Test
    public void testLevelOrder(){

        TreeNode root = new TreeNode(3);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);

        root.left = root2;
        root.right = root3;
        root2.right = root4;
        root3.left = root5;

//        List<List<Integer>> lists = levelOrder(root);
        List<List<Integer>> lists = levelOrder(null);
        lists.forEach(k->k.forEach( v -> System.out.print(v+",")));

//        levelOrder(root).stream().map(Collection::stream).forEach(System.out::print);
    }

}
