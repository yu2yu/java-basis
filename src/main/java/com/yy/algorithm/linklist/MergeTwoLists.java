package com.yy.algorithm.linklist;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/30
 */
public class MergeTwoLists {

    public LinkNode mergeTwoLists(LinkNode node1,LinkNode node2){
        LinkNode mergeNode = new LinkNode();
        LinkNode node = mergeNode;
        // 合并两个有序链表
        while(node1!=null&&node2!=null){
            if(node1.val<node2.val){
                node.next = node1;
                node1 = node1.next;
            }else{
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        node.next = node1!=null?node1:node2;
        return mergeNode.next;
    }


    public static void main(String[] args) {
        LinkNode node1 = new LinkNode().getNodeList();

        LinkNode l1 = new LinkNode(2);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(3);
        LinkNode l4 = new LinkNode(4);
        LinkNode l5 = new LinkNode(5);

        l1.next = l2;
        l2.next = l3;

        LinkNode node = new MergeTwoLists().mergeTwoLists(node1, l1);

        while(node!=null){
            System.out.print(node.val+"=>");
            node = node.next;
        }
    }
}
