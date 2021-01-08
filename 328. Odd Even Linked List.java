// 328. Odd Even Linked List

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

// 最优解：
// odd结点通过even结点的next域(指向即下一个odd结点)连接
// even结点通过修改后的odd结点的next域(指向下一个even结点)连接
// 保留第一个even结点的指针
// 最后使用odd结点连接第一个even结点 即为所求

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode odd = head, even = head.next, evenHead = head.next;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}