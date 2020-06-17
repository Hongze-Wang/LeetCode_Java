// 24. Swap Nodes in Pairs

// 100% faster, easy java two pointer solution
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode curr, last, temp, newhead;
        last = head;
        curr = head.next;
        newhead = head.next;
        while(curr != null) {
            temp = curr.next;
            curr.next = last;
            last.next = temp;
            if(temp == null || temp.next == null) return newhead;
            else {
                last.next = temp.next;
                curr = temp.next;
                last = temp;
            }
        }
        return newhead;
    }
}
