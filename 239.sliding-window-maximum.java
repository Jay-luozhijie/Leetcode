/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int leftPtr = 0;
        int rightPtr = k - 1;
        int size = 0;
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 0; i < k; i++){
            while(size != 0 && deque.peekLast() < nums[i]){
                deque.removeLast();
                size--;
            }
            deque.addLast(nums[i]);
            size++;
        }
        System.out.println("hello");
        result[0] = deque.peekFirst();
        while(rightPtr < nums.length - 1){
            if(deque.peekFirst() == nums[leftPtr]){
                deque.removeFirst();
                size--;
            }
            rightPtr++;
            leftPtr++;
            while(size != 0 && deque.peekLast() < nums[rightPtr]){
                deque.removeLast();
                size--;
            }
            deque.addLast(nums[rightPtr]);
            size++;
            result[leftPtr] = deque.peekFirst();
           
        }
        return result;
    }
}
// @lc code=end

