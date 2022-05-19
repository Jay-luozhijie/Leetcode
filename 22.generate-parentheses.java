import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public static List<String> result = new ArrayList<>();
    // public static String concat(Stack<Character> stack){
    //     String result = "";
    //     while(!stack.isEmpty()){
    //         result = stack.pop() + result;
    //     }
    //     System.out.println(result);
    //     System.out.println(stack.size());
    //     return result;
    // }
    public static void backtrack(Stack<String> stack, int left, int right, int n){
        if(left == right && left == n){
            System.out.println(stack.size());
            result.add(String.join("",stack));
            System.out.println("hello");
            return;
        }
        if(left < n){
            stack.push("(");
            backtrack(stack, left + 1, right,n);
            System.out.println(stack.size());
            stack.pop();
        }
        if(right < left){
            stack.push(")");
            backtrack(stack, left, right + 1,n);
            System.out.println(stack.size());
            stack.pop();
        }
        return;
    }
    public List<String> generateParenthesis(int n) {
        Stack<String> stack = new Stack<>();
        result = new ArrayList<>();
        backtrack(stack, 0, 0, n);
        return result;
    }
}
// @lc code=end

