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

// a denote the step from head to the entry node of the circle
// b denote the step from the entry node to the meed node on the circle
// c denote the step from the meet node on the circle to the entry node
//
// circle length l
// because of the speed
// 2(a+b) = a+b + nl
// a = nl - b = (n-1)l + l - b
// from the meeting point, fast walk b more steps to finish the circle
// l = a+b

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
