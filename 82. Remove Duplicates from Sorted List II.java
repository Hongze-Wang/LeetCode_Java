// 82. Remove Duplicates from Sorted List II

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
//     public ListNode deleteDuplicates(ListNode head) {
//         if(head != null && head.next != null) {
//             if(head.val != head.next.val) {
//                 head.next = deleteDuplicates(head.next);
//             } else {
//                 while(head.next != null && head.val == head.next.val) {
//                     head = head.next;
//                 }
//                 return deleteDuplicates(head.next);
//             }
//         }
//         return head;
//     }
// }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode dummyHead = new ListNode(-1), pre = dummyHead, temp;
        dummyHead.next = head;
        while(pre.next != null && pre.next.next != null) {
            if(pre.next.val == pre.next.next.val) {
                temp = pre;
                while(temp.next.next != null && temp.next.val == temp.next.next.val) {
                    temp = temp.next;
                }
                temp = temp.next.next;
                pre.next = temp;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }
}
