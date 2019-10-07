// 189. Rotate Array

// Using another array
class Solution {
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            res[(i+k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}

// 100% faster 100% less memory
// Three times reverse is equal to cyclic shift k times
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length -1);
    }
    public void reverse(int[] nums, int low, int high) {
        int temp;
        while(low < high) {
            temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}