// 203. Remove Linked List Elements

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 新建一个头结点 重构链表
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while(head != null) {
            if(head.val != val) {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        cur.next = null;
        return newHead.next;
    }
}

// 递归形式
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        if(head.val == val) {
            return removeElements(head.next, val);
        }
        head.next = removeElements(head.next, val);
        return head;
    }
}

// 用一个指针在原链表上操作 我觉得这个是最优解
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val)  {
            head = head.next;
        }
        if(head == null) return null;
        ListNode cur = head;
        while(cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}