package LeetCode;
// 88. Merge Sorted Array
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0) {
            return;
        }
        mergeArray(nums1, m, nums2, n);
    }

    private void mergeArray(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int i = m-1;
        int j = n-1;

        while(i >= 0 && j >=0) {
            if(nums1[i] < nums2[j]) {
                nums1[index--] = nums2[j--];
            } else {
                nums1[index--] = nums1[i--];
            }
        }
        while(j>-1) nums1[index--] = nums2[j--];
        while(i>-1) nums1[index--] = nums1[i--];
    }
}
