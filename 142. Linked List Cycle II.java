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

// s denote the distance from the head to the node meet on the circle
// t denote the distance from the head to the entry node
// v denote the distance from the entry node to the meet node onr the circle
// s = t + v
// p denote the distance from the meet node on the circle to the entry node of the circle
// n denote the circle length
// n = v + p
// when slow and fast meet on the circle
// slow run length s
// fast run lengtn s + n
// becase 2 * slow.speed == fast.speed
// 2 * s = s + n
// so s == n
// t + v = v + p
// t == p
// so the distance from the head to the entry node == distance from the meet node on the circle to the entry node of the circle
// reset the slow to the head
// fast and slow run at the speed
// when they meet, they meet at the entry of the circle 

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