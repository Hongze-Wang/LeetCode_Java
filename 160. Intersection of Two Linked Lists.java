// 160. Intersection of Two Linked Lists
// 更多解法见TargetOffer36 提供三种语言的解法

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if(p1 != p2) {
                if(p1 == null) {
                    p1 = headB;
                }
                if(p2 == null) {
                    p2 = headA;
                }
            }
        }
        return p1;
    }
}