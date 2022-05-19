/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public static int returnOne(String str){
        int one = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1') {one++;}
        }
        return one;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][]dp = new int[strs.length + 1][m + 1][n + 1];           
        for(int k = 1; k <= strs.length; k++){
            for(int i = 0; i <= m; i++){
                for(int j = 0; j <= n; j++){
                    int zero = strs[k-1].length() - returnOne(strs[k-1]);
                    int one = returnOne(strs[k-1]);
                    dp[k][i][j] = i-zero >= 0
                                && j - one >=0
                                ? Math.max(dp[k-1][i][j], 1 + dp[k-1][i-zero][j-one])
                                : dp[k-1][i][j];
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
// @lc code=end

