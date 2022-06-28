import java.util.*;
/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 */

// @lc code=start
class MyCircularDeque {
    public int head;
    public int tail;
    public int[] array;
    public int size = 0;
    public int limit;

    public MyCircularDeque(int k) {
        array = new int[k];
        limit = k;
        head = k-1;
        tail = 0;
    }
    
    public boolean insertFront(int value) {
       if(size < limit){
            size++;
            head = (head + 1) % limit;
            array[head] = value;
            
            
            
            return true;
       } else {
            return false;
       }
    }
    
    public boolean insertLast(int value) {
        if(size < limit){
            size++;
            tail = (tail + limit - 1) % limit;
            array[tail] = value;
            
           
           
            return true;
       } else {
            return false;
       }
    }
    
    public boolean deleteFront() {
        if(size > 0){
            head = (head + limit - 1) % limit;
            size--;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean deleteLast() {
        if(size > 0){
            tail = (tail + 1) % limit;
            size--;
            return true;
        } else {
            return false;
        }
    }
    
    public int getFront() {
        if(size > 0){
            return array[head];
        } else {
            return -1;
        }
    }
    
    public int getRear() {
        if(size > 0){
            return array[tail];
        } else {
            return -1;
        }
    }
    
    public boolean isEmpty() {
        return size <= 0;
    }
    
    public boolean isFull() {
        return size == limit;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

