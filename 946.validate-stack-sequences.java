import java.util.*;

/*
 * @lc app=leetcode id=946 lang=java
 *
 * [946] Validate Stack Sequences
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0; i < popped.length; i++){
            queue.add(popped[i]);
        }
        for(int i = 0; i < pushed.length; i++){
            stack.push(pushed[i]);
            // if(stack.peek() == queue.getFirst()){
                while(!stack.isEmpty() && stack.peek().equals(queue.getFirst())){
                    // System.out.println("enter while");
                    // System.out.println(stack.pop());
                    stack.pop();
                    queue.removeFirst();
                }
                // System.out.println("is stack empty:");
                // System.out.println(stack.isEmpty());
            // }
        }
        boolean result = stack.isEmpty();
        // while(!stack.isEmpty()){
        //     System.out.println(stack.pop());
        // }
        return result;
    }
}
// @lc code=end

