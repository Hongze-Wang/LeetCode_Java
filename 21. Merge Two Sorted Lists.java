// 21. Merge Two Sorted Lists

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
// class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         ListNode head = new ListNode(-1);
//         ListNode node = head;

//         while(l1 != null && l2 != null) {
//             if(l1.val > l2.val) {
//                 node.next = l2;
//                 node = node.next;
//                 l2 = l2.next;
//             } else {
//                 node.next = l1;
//                 node = node.next;
//                 l1 = l1.next;
//             }
//         }

//         node.next = l1 == null ? l2 : l1;
//         return head.next;
//     }
// }

// Recursive Solution

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}
