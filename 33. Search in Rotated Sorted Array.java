// 33. Search in Rotated Sorted Array

// O(logn) means that you must use log(n) search algorithm
// Still use binary search, but only judge when there is less or equal than two elem
class Solution {
    private int index = -1;

    public int search(int[] nums, int target) {
        if(nums.length == 1) {
            if(nums[0] == target) return 0;
            else return -1;
        }
        int mid = nums.length / 2;
        search(nums, 0, mid, target);
        search(nums, mid, nums.length, target);
        return index;
    }

    private void search(int[] nums, int left, int right, int target) {
        int len = right - left;
        if(index != -1) {
            return;
        }
        if(len <= 2) {
            for(int i=0; i<len; i++) {
                if(nums[left + i] == target) {
                    index = left+i;
                }
            }
            return;
        }
        int mid = (left + right) / 2;
        search(nums, left, mid, target);
        search(nums, mid, right, target);
    }
}

// 33. Search in Rotated Sorted Array
// Same solution as 81. Search in Rotated Sorted Array II.java

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if(nums[0] == target) return 0;
        
        int low=0, high=nums.length-1, mid;
        while(low <= high) {
            mid = low + (high-low) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < nums[high]) {
                if(nums[mid] < target && nums[high] >= target) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else {
                if(nums[mid] > target && nums[low] <= target) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}

class Solution {
    public int search(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        while(low <= high) {
            int mid = low + (high-low >> 1); // 右移运算优先级最低
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] > target) {
                if(arr[mid] > arr[high] && arr[high] >= target) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else {
                if(arr[mid] < arr[low] && arr[low] <= target) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
        }
        // if(low < arr.length && arr[low] == target) return low; // leetcode 不要求返回重复元素最低索引
        return -1;
    }
}

/*
The above solution can not pass 程序员面试金典第六版(leetcode-cn)：面试题 10.03. Search Rotate Array LCCI for the following case:

[1,1,1,1,1,2,1,1,1]
2

output: -1
expected: 5

details refer to 面试题 10.03. Search Rotate Array LCCI.
*/
