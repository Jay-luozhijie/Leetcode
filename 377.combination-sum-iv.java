/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        // int[][]dp = new int[nums.length + 1][target + 1];
        // dp[0][0] = 1;
        // for(int i = 1; i < nums.length + 1; i++){
        //     for(int j = 0; j < target + 1; j++){
        //         int left = j - nums[i - 1] >= 0 ? dp[i][j-nums[i - 1]] : 0;
        //         int up = dp[i-1][j];
        //         dp[i][j] = left + up;
        //         System.out.println("(" + i+ ", " + j + "): " + dp[i][j]);
        //     }
        // }
        // return dp[nums.length][target];
        int[]dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i < target + 1; i++){
            for(int j = 0; j < nums.length; j++){
                if(i - nums[j] >= 0){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
// @lc code=end

