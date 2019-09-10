package LeetCode;
// 83.Remove Duplicates from Sorted List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode rear = head;
        while(rear.next != null) {
            if(rear.val == rear.next.val) rear.next = rear.next.next;
            else rear = rear.next;
        }
        return head;
    }
}
