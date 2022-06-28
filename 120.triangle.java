import java.util.*;
/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][]dp = new int[size][size];
        for(int i = size - 1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                if(i == size - 1){
                    dp[i][j] = triangle.get(i).get(j);
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

