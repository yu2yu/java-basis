package com.yy.algorithm.linklist;


/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/30
 */
public class LinkNode {

    int val;
    LinkNode next;
    LinkNode() {}
    LinkNode(int val) { this.val = val; }
    LinkNode(int val, LinkNode next) { this.val = val; this.next = next; }


    public LinkNode getNodeList(){
        LinkNode l1 = new LinkNode(1);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(3);
        LinkNode l4 = new LinkNode(4);
        LinkNode l5 = new LinkNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        return l1;
    }
}
