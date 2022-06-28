import java.util.*;
/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        // int index = stones.length;
        // while(index > 1){
        //     int max = stones[0];
        //     int firstIndex = 0;
        //     for(int i = 0; i < index; i++){
        //         if(stones[i] > max){
        //             max = stones[i];
        //             firstIndex = i;
        //         }
        //     }
        //     int secondMax = firstIndex == 0 ? stones[1] : stones[0];
        //     int secondIndex = firstIndex==0 ? 1 : 0;
        //     for(int i = 0; i < index; i++){
        //         if(stones[i] > secondMax && i != firstIndex){
        //             secondMax = stones[i];
        //             secondIndex = i;
        //         }
        //     }
        //     int smashResult = max - secondMax;
        //     if(smashResult == 0){
        //         if(firstIndex != index - 1 && secondIndex != index - 1){
        //             int temp = stones[firstIndex];
        //             stones[firstIndex] = stones[index - 1];
        //             stones[index - 1] = temp;
        //             index--;
        //             temp = stones[secondIndex];
        //             stones[secondIndex] = stones[index - 1];
        //             stones[index - 1] = temp;
        //             index--;
        //         } else if(firstIndex == index - 1){
        //             index--;
        //             int temp = stones[secondIndex];
        //             stones[secondIndex] = stones[index - 1];
        //             stones[index - 1] = temp;
        //             index--;
        //         } else {
        //             index--;
        //             int temp = stones[firstIndex];
        //             stones[firstIndex] = stones[index - 1];
        //             stones[index - 1] = temp;
        //             index--;
        //         }
               
        //     } else {
        //         stones[firstIndex] = smashResult;
        //         int temp = stones[secondIndex];
        //         stones[secondIndex] = stones[index - 1];
        //         stones[index - 1] = temp;
        //         index--;
        //     }
        // }
        // if(index == 1){
        //     return stones[0];
        // } else {
        //     return 0;
        // }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++){
            pq.add(stones[i]);
        }
        while(pq.size() > 1){
            int first = pq.remove();
            int second = pq.remove();
            if(first - second != 0){
                pq.add(first - second);
            }
        }
        if(pq.size() == 0){
            return 0;
        } else {
            return pq.remove();
        }
    }
}
// @lc code=end

