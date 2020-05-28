// 61. Rotate List

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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode temp = head, end = null;
        int len = 0;
        while(temp != null) {
            if(temp.next == null) end = temp;
            temp = temp.next;
            len++;
        }
        if(len < k) k %= len;
        if(len == k || k == 0) return head;

        int cout = 1;
        ListNode start = head;
        temp = head;
        while(cout < len-k) {
            temp = temp.next;
            cout++;
        }
        head = temp.next;
        temp.next = null;
        end.next = start;
        return head;
    }
}
