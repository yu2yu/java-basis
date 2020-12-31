package com.yy.algorithm.linklist;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/30
 */
public class AddTwoNumbers {

    public LinkNode addTwoNumbers(LinkNode l1,LinkNode l2){
        LinkNode node = new LinkNode(0);
        // 哨兵节点
        LinkNode prev = node;
        int flag = 0;
        // 需要考虑是否等于9
        while(l1 != null || l2 != null || flag!=0){
            if(l1 != null){
                flag += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                flag += l2.val;
                l2 = l2.next;
            }
            node.next = new LinkNode(flag % 10);
            node = node.next;
            flag = flag / 10;
        }
        return prev.next;
    }

    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(0);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(3);
        LinkNode l4 = new LinkNode(4);
        LinkNode l5 = new LinkNode(5);
        LinkNode l6 = new LinkNode(9);
        LinkNode l7 = new LinkNode(0);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next=l5;
        l5.next = l6;
        l6.next = l7;

        LinkNode node = new AddTwoNumbers().addTwoNumbers( l1,l4);
        while(node!=null){
            System.out.print(node.val+"=>");
            node = node.next;
        }
    }

}
