import java.util.*;
/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // boolean[][]dp = new boolean[wordDict.size()][s.length() + 1];
        // for(int i = wordDict.size() - 1; i >= 0; i--){
        //     for(int j = s.length(); j >= 0; j--){
        //         if(j == s.length()){
        //             dp[i][j] = true;
        //         } else {
        //             int len = wordDict.get(i).length();
        //             boolean right = false;
        //             boolean down = false;
        //             if(j + len <= s.length() && s.substring(j, j + len).equals(wordDict.get(i))){
        //                 right = dp[i][j+len];
        //             }
        //             if(i + 1 < wordDict.size()){
        //                 down = dp[i + 1][j];
        //             }
        //             dp[i][j] = right || down;
        //         }
        //     }
        // }
        // return dp[0][0];
        boolean[]dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = 0; j < wordDict.size(); j++){
                if(i + wordDict.get(j).length() <= s.length() 
                && wordDict.get(j).equals(s.subSequence(i, i + wordDict.get(j).length()))){
                    dp[i] = dp[i] || dp[i + wordDict.get(j).length()];
                }
            }
        }
        return dp[0];
    }
}
// @lc code=end

