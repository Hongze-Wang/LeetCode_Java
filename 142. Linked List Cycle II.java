// 142. Linked List Cycle II
// Mind the difference with previous question

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// s denote the step slow go when fast and slow meet on the circle
// a denote the step from head to the entry node of the circle
// b denote the step from the entry node to the meed node on the circle
// c denote the step from the meet node on the circle to the entry node
// s = a + b
// circle length len = b + c
// because of the speed
// 2s = s + nlen
// s = len
// a + b = b + c
// a = c

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        
        while(slow != fast) {
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
