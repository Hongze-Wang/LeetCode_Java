// 141. Linked List Cycle

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


// Using HashSet 
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         if(head == null) return false;
        
//         HashSet<ListNode> set = new HashSet();
//         while(head != null) {
//             if(set.contains(head)) {
//                 return true;
//             } else {
//                 set.add(head);
//             }
//             head = head.next;
//         }
//         return false;
//     }
// }

// two pinters method
// fast is twice the speed as the slow
// so when fast == slow, they are at the same node in the circle
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != fast) {
            if(fast == null || fast.next == null) return false;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

// The recommend implement way
// You will see their difference in the 142 Linked List Cycle II

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        
        while(slow != fast) {
            if(fast == null || fast.next == null) return false;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}