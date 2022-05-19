/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
          int max = nums[0];
          int value = 0;
          for(int i = 0; i < nums.length; i++){
              if(value < 0){
                  value = 0;
              }
            value += nums[i];
            max = Math.max(max, value);
          }
        return max;
    }
}
// @lc code=end

