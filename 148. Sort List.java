// 148. Sort List

// mergeSort refer to python solution

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

// same soltion as 147. Insertion Sort List 8% faster

// class Solution {
//     public ListNode sortList(ListNode head) {
//         ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
//         ListNode cur = head, pre = dummyHead, temp;
//         while(cur != null) {
//             if(pre.val > cur.val) pre = dummyHead;              // pre reset to dummyHead if current node can not be insert to pre.next
//             while(pre.next != null && cur.val > pre.next.val) { // find insert position
//                 pre = pre.next;
//             }
//             // insert cur at pre.next
//             temp = cur.next;
//             cur.next = pre.next;
//             pre.next = cur;
//             cur = temp;
//         }
//         return dummyHead.next;
//     }
// }

// using PriorityQueue

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        while(head != null) {
            pq.offer(head.val);
            head = head.next;
        }
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE), cur = dummyHead;
        while(pq.size() != 0) {
            int t = pq.poll();
            ListNode node = new ListNode(t);
            cur.next = node;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
