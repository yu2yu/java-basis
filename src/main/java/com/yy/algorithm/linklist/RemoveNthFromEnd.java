package com.yy.algorithm.linklist;


import sun.awt.image.ImageWatched;

/**
 * @version 1.0
 * @description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @author: yy
 * @date: 2020/12/30
 */
public class RemoveNthFromEnd {

    public LinkNode removeNthFromEnd(LinkNode head, int n){
        if(n<=0) return head;
        // 最差劲的办法就是循环两次
        int size = 0;
        LinkNode node = head;
        while(node != null){
            node = node.next;
            size++;
        }
        if(size<n) {
            return head;
        }else if(size == n){
            return head.next;
        }
        node = head;
        LinkNode prev = new LinkNode();
        prev.next = head;
        int count = 0;
        while(count < (size-n)) {
            prev = node;
            node = node.next;
            count++;
        }
        prev.next = node.next;
        return head;
    }


    public LinkNode removeNthFromEnd2(LinkNode head, int n){
        if(n<=0) return head;
        // 怎么减少内存消耗，设置两个指针，相隔n距离
        LinkNode prevHead = new LinkNode();
        prevHead.next = head;

        LinkNode node = head;
        while(node!=null && n>1){
            node = node.next;
            n--;
        }

        if(node == null) return head;
        // 两种情况
        // 1. node就是末尾,删除头结点
        if(node.next == null) return head.next;
        // 2.
        while(node.next != null){
            node = node.next;
            prevHead = prevHead.next;
        }
        prevHead.next = prevHead.next.next;
        return head;
    }

    public LinkNode removeNthFromEnd3(LinkNode head,int n){
        // 设置前节点，以防头结点删除
        LinkNode prevHead = new LinkNode(0,head);
        LinkNode node = head;
        LinkNode pre = prevHead;
        int i = 1;
        while (node!=null&&node.next!=null){
            if (i>=n){
                pre=pre.next;
            }
            node=node.next;
            i++;
        }
        pre.next = pre.next.next;
        return prevHead.next;
    }

    public static void main(String[] args) {

        LinkNode l1 = new LinkNode().getNodeList();

//        LinkNode node = new RemoveNthFromEnd().removeNthFromEnd(l1, 2);
//        LinkNode node = new RemoveNthFromEnd().removeNthFromEnd2(l1, 1);
        LinkNode node = new RemoveNthFromEnd().removeNthFromEnd3(l1, 2);

        while(node!=null){
            System.out.print(node.val+"=>");
            node = node.next;
        }
    }

}
