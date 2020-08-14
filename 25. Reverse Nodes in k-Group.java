// 25. Reverse Nodes in k-Group

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
    private int getLength(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 0) return null;
        ListNode prev = null, cur = null, nextNode = head;
        int count = 0;
        while(nextNode != null && count < k) {
            prev = cur;
            cur = nextNode;
            nextNode = nextNode.next;
            cur.next = prev; // 指针置反
            count++;
        }
        if(nextNode != null) {
            int len = getLength(nextNode);
            if(k > len) {
                head.next = nextNode;
            } else {
                ListNode newHead = reverseKGroup(nextNode, k);
                head.next = newHead;
            }
        }
        return cur;
    }
}
