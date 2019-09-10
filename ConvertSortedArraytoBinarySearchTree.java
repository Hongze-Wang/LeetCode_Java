package LeetCode;
// 108. Convert Sorted Array to Binary Search Tree
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int nums[]) {
        return toBSTrecursive(nums, 0, nums.length-1);
    }

    private TreeNode toBSTrecursive(int nums[], int left, int right) {
        if(right < left) { return null; }
        if(right == left) {
            return new TreeNode(nums[left]);
        }
        int mid = left + (right-left)/2;
        TreeNode parent = new TreeNode(nums[mid]);
        parent.left = toBSTrecursive(nums, left, mid-1);
        parent.right = toBSTrecursive(nums, mid+1, right);
        return parent;
    }
}
