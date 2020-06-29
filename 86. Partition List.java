// 86. Partition List

// two pointers

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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode lowhead = new ListNode(-1);
        ListNode highhead = new ListNode(-1);
        ListNode low = lowhead, high = highhead;
        while(head != null) {
            if(head.val < x) { 
                low.next = head;
                low = head;
            } else {
                high.next = head;
                high = head;
            }
            head = head.next;
        }
        high.next = null;
        low.next = highhead.next;
        return lowhead.next;
    }
}
