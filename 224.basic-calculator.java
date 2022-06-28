import java.util.*;
/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public Stack<Character> stack = new Stack<>();
    public void pushValue(int value){
        String number = String.valueOf(value);
        System.out.println(number);
        for(int i = 0; i < number.length(); i++){
            stack.push(number.charAt(i));
        }
    }
    public int obtainNumber(){
        String value = "";
        while(!stack.isEmpty() && Character.isDigit(stack.peek())){
            value = stack.pop() + value;
        }
        System.out.println("obtain value");
        System.out.println(value);
        if(value == ""){
            return 0;
        } else {
            return Integer.valueOf(value);
        }
    }
    public int obtainSign(){
        int value = 1;
        System.out.println("obtain sign");
        while(!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')){
            if(stack.peek() == '-'){
                System.out.println("===");
                value *= -1;
            }
            stack.pop();
        }
        System.out.println(value);
        return value;
    }
    public int calculateInside(){
        int value = 0;
        while(!stack.isEmpty()){
            if(stack.peek() == '('){
                stack.pop();
                break;
            }else {
                value += obtainNumber() * obtainSign();
            }                                                              
        }
        return value;
    }
    public int calculate(String s) {
        int index = 0;
        int sum = 0;
        while(index < s.length()){
            if(s.charAt(index) == ')'){
                int value = calculateInside();
                // if(value < 0){
                //     stack.push('-');
                //     pushValue(value);
                // } else {
                //     pushValue(value);
                // }
                pushValue(value);
                index++;
            } else if(s.charAt(index) == ' '){
                index++;
            } else {
                stack.push(s.charAt(index));
                index++;
            }
        }
        // System.out.println("hello");
        while(!stack.isEmpty()){
            sum += obtainNumber() * obtainSign();
        }
        return sum;
    }
}
// @lc code=end

