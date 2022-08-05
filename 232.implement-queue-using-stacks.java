import java.util.*;
/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {
    public Stack<Integer> firstStack;
    public Stack<Integer> secondStack;

    public MyQueue() {
        firstStack = new Stack<Integer>();
        secondStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        firstStack.push(x);
    }
    
    public int pop() {
        if(secondStack.isEmpty()){
            while(!firstStack.isEmpty()){
                secondStack.push(firstStack.pop());
            }
            return secondStack.pop();
        } else {
            return secondStack.pop();
        }
    }
    
    public int peek() {
        if(secondStack.isEmpty()){
            while(!firstStack.isEmpty()){
                secondStack.push(firstStack.pop());
            }
            return secondStack.peek();
        } else {
            return secondStack.peek();
        }
    }
    
    public boolean empty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

