// 206. Reverse Linked List

// 100% faster 100% less memory
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Iteration way
// Classic head insert method two line

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        
        ListNode curr = head, prev = null, temp;
        while(curr != null) {
            temp = curr.next; // Store the next node to manipulate
            curr.next = prev; // Head insert method start
            prev = curr;      // Head insert method end
            curr = temp;      // Update the curr cursor
        }
        return prev;
    }
}

// Recursive way

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
}