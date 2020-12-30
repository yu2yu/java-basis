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
}
