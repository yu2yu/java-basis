package com.yy.algorithm.day.D20210520;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


/**
 *  @description  前K个高频单词
 *
 *  给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *  返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 *  输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 *  输出: ["i", "love"]
 *  解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 */
public class TopKFrequent {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> frequent = new HashMap<>();
        for (String word : words) {
            // TODO：这样判断hashMap中key是否存在
            frequent.put(word,frequent.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<Map.Entry<String, Integer>>(
                (a, b) -> a.getValue() == b.getValue()
                        ? b.getKey().compareTo(a.getKey())
                        : a.getValue() - b.getValue()
        );

        // 循环遍历
        for (Map.Entry<String, Integer> stringIntegerEntry : frequent.entrySet()) {
            priorityQueue.offer(stringIntegerEntry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }


        ArrayList<String> list = new ArrayList<>();
        while(priorityQueue.peek() != null){
            list.add(priorityQueue.poll().getKey());
        }
        Collections.reverse(list);
        return list;

    }


    @Test
    public void testTopKFrequent(){
        topKFrequent(
                new String[]{"glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"},
                14).forEach(System.out::print);




    }

}
