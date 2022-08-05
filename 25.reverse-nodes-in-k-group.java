import java.util.*;

/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode skipNode(ListNode head, int step){
        ListNode test = head;
        int count = 0;
        while(count < step){
            if(test == null) return null;
            count++;
            test = test.next;
        }
        return test;
    }
    public ListNode reverseSubGroup(ListNode head, int size){
        ListNode test = head;
        int count = 0;
        while(count < size){
            if(test == null) return head;
            count++;
            test = test.next;
        }
        count = 0;
        ListNode left;
        ListNode right = head;
        ListNode start = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        left = dummy;
        while(count < size){
            ListNode next = right.next;
            right.next = left;
            count++;
            left = right;
            right = next;
        }
        start.next = right;
        return left;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode ptr = dummy;
        while(ptr != null){
            ptr.next = reverseSubGroup(ptr.next, k);
            ptr = skipNode(ptr, k);
        }
        return dummy.next;
    }
}
// @lc code=end

