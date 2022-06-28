/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        while(left <= right){
            if(maxLeft < maxRight){
                sum += maxLeft - height[left] >= 0
                ?maxLeft - height[left]
                :0;
                maxLeft = Math.max(maxLeft, height[left]);
                left++;
            } else {
                sum += maxRight - height[right] >= 0
                ?maxRight - height[right]
                :0;
                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
        }
        return sum;
    }
}
// @lc code=end

