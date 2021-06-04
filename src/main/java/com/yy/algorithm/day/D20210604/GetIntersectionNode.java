package com.yy.algorithm.day.D20210604;

import com.google.common.collect.Maps;
import com.yy.algorithm.linklist.LinkNode;
import org.junit.Test;

import java.util.HashMap;

public class GetIntersectionNode {


    public LinkNode getIntersectionNode(LinkNode headA, LinkNode headB){
        HashMap<LinkNode, Integer> hashMap = Maps.newHashMap();
        while(headA != null){
            hashMap.put(headA,1);
            headA = headA.next;
        }
        while(headB != null){
            if(hashMap.getOrDefault(headB,0) != 0){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }



    public LinkNode getIntersectionNodeTwo(LinkNode headA, LinkNode headB){

        LinkNode pA = headA,pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    @Test
    public void testIntersection(){


        LinkNode l1 = new LinkNode(1);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(3);
        LinkNode l4 = new LinkNode(4);
        LinkNode l5 = new LinkNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        LinkNode l6 = new LinkNode(6);
        LinkNode l7 = new LinkNode(7);

        l6.next = l7;
        l7.next = l3;

        System.out.println(getIntersectionNode(l1,l6).val);
    }

}
