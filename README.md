### java

#### algorithm

##### [找出第 K 大的异或坐标值](https://github.com/yu2yu/java-basis/blob/master/src/main/java/com/yy/algorithm/day/D20210519/KthLargestValue.java)

topK最大堆的解法：
```java
if(queue.size() < k){
    queue.add(pre[i][j]);
}else{
    if(queue.peek() < pre[i][j]){
        queue.poll();
        queue.add(pre[i][j]);
    }
}
```