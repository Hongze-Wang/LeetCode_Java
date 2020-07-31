// 445. Add Two Numbers II

// Standrd Solution: using two stacks

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0, carry = 0;
        ListNode dummyHead = new ListNode(-1);
        while(!s1.empty() || !s2.empty()) {
            int a = s1.empty() ? 0 : s1.pop();
            int b = s2.empty() ? 0 : s2.pop();
            sum = a+b+carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode curNode = new ListNode(sum);
            curNode.next = dummyHead.next;
            dummyHead.next = curNode;
        }
        if(carry == 1) {
            ListNode node = new ListNode(1);
            node.next = dummyHead.next;
            dummyHead.next = node;
        }
        return dummyHead.next;
    }
}
