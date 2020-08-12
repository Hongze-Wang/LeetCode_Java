// 147. Insertion Sort List

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

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = head, pre = dummyHead, temp;
        while(cur != null) {
            if(pre.val > cur.val) pre = dummyHead;              // pre reset to dummyHead if current node can not be insert to pre.next
            while(pre.next != null && cur.val > pre.next.val) { // find insert position
                pre = pre.next;
            }
            // insert cur at pre.next
            temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
        }
        return dummyHead.next;
    }
}
