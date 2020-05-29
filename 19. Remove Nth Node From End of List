// 19. Remove Nth Node From End of List

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

// leverage the fact n-th node from the end of the list is the L-n+1-th node from the begining
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         int len = 0;
//         ListNode p = head;
//         while(p != null) {
//             len++;
//             p = p.next;
//         }
//         len -= n;
//         p = dummy;
//         while(len > 0) {
//             p = p.next;
//             len--;
//         }
//         p.next = p.next.next;
//         return dummy.next;
//     }
// }

// two pointers first advances second for n+1 step
// dummy is needed for the case there is only one node
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i=1; i<=n+1; i++) { // n+1 because we want second move to the node before the node we need delete
            first = first.next;
        }
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
