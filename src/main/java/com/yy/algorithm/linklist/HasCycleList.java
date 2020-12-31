package com.yy.algorithm.linklist;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/30
 */
public class HasCycleList {

    public boolean hasCycle(LinkNode head) {
        ArrayList<LinkNode> nodes = new ArrayList<>();
        // map存储节点
        while(head != null){
            if(nodes.contains(head)){
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(LinkNode head) {
        // 使用快慢指针
        LinkNode fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            head = head.next;
            if(head == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(1);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(3);
        LinkNode l4 = new LinkNode(4);
        LinkNode l5 = new LinkNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        l5.next = l2;

        System.out.println(new HasCycleList().hasCycle2(l1));
    }

}
