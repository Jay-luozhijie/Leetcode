import java.util.*;
/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    class Pair{
        int index;
        int value;
        public Pair(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && stack.peek().value <temperatures[i]){
                result[stack.peek().index] = i - stack.peek().index;
                stack.pop();
            }
            stack.push(new Pair(i, temperatures[i]));
        }
        while(!stack.isEmpty()){
            result[stack.pop().index] = 0;
        }
        return result;                                      
    }
}
// @lc code=end

