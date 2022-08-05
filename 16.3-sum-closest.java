import java.util.*;
/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        int closestGap = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int twoSumTarget = target - nums[i];
            int twoSum;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                twoSum = nums[left] + nums[right];
                if(Math.abs(twoSum - twoSumTarget) < closestGap){
                    closestGap = Math.abs(twoSum - twoSumTarget);
                    closestSum = nums[i] + twoSum;
                }
                if(twoSum < twoSumTarget) left++;
                else if(twoSum > twoSumTarget) right--;
                else return closestSum;
            }
        }
        return closestSum;
    }
}
// @lc code=end

