// 109. Convert Sorted List to Binary Search Tree

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private TreeNode sortedListToBST(ArrayList<Integer> list, int left, int right) {
        if(right < left) { return null; }
        if(right == left) {
            return new TreeNode(list.get(left));
        }
        int mid = left + (right-left)/2;
        TreeNode parent = new TreeNode(list.get(mid));
        parent.left = sortedListToBST(list, left, mid-1);
        parent.right = sortedListToBST(list, mid+1, right);
        return parent;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ArrayList<Integer> list = new ArrayList();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        return sortedListToBST(list, 0, list.size()-1);
    }
    
}
