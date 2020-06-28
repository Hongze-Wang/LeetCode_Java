// 234. Palindrome Linked List

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid, fast;
        mid = fast = head;

        while(fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        ListNode next, last; // regard mid as curr, reverse the linklist from mid
        next = last = null;
        while(mid != null) {
            next = mid.next;
            mid.next = last;
            last = mid;
            mid = next;
        }

        while(last != null) {
            if(last.val != head.val) return false;
            last = last.next;
            head = head.next;
        }
        return true;
    }
}

// class Solution {
//     boolean flag = true;
//     private ListNode isPalindrome(ListNode p1, ListNode p2) {
//         if(p1 == null) return p2;
//         ListNode node = isPalindrome(p1.next, p2);
//         if(node.val != p1.val) flag = false;
//         return node.next;
//     }
//     public boolean isPalindrome(ListNode head) {
//         ListNode p1, p2;
//         p1 = p2 = head;
//         isPalindrome(p1, p2);
//         return flag;
//     }
// }
