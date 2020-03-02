// 2. Add Two Numbers
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// The following is the official solution
// 辅助头结点 尾插法
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = sumHead;
        int carry = 0;
        while(p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry > 0) { // handle the last carry bit
        curr.next = new ListNode(carry);
        }
        return sumHead.next;
    }
}

// Recursion 100% faster 91.22% less memory
// I think this is faster because the way it handles the sum and the carry,
// not the algorithm
class Solution {
    public int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 ==null) {
            if(carry == 0) return null;
            return new ListNode(carry);
        }
        int res = carry;
        if(l1 != null) {
            res += l1.val;
            l1 = l1.next;
        }
        if(l2 != null) {
            res += l2.val;
            l2 = l2.next;
        }
        if(res >= 10) {
            carry = 1;
            res = res % 10;
        } else {
            carry = 0;
        }
        ListNode head = new ListNode(res);
        head.next = addTwoNumbers(l1, l2);
        return head;
    }
}