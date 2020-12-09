// 100% 16.77%
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;

        int[] bucket = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0 && nums[i] <= nums.length) {
                bucket[nums[i]-1]++;
            }
        }

        int i=0;
        while(i <nums.length && bucket[i] != 0) {
            i++;
        }
        return i+1;
    }
}

// 100% faster 52.09% memory less O(n) O(1)
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;

        // step1: preprocess and check if one exist
        boolean flag = false;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                flag = true;
            } else if(nums[i] <= 0 || nums[i] > nums.length) { // 边界外全置1
                nums[i] = 1;
            }
        }
        // if one does not exist, it is the First Missing Positive integer
        if(!flag) return 1;

        // step2: map the elememts in the array into the index they equals to
        //        change the element at that index as negative to denote the element shoule at that position has already existed
        for(int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] > 0) nums[idx] = -nums[idx];
        }
        
        // step3: find the first element in the array that is positive, the index reflects the First Missing Positive integer
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) return i+1;
        }
        // if all the element are negative, return length+1 because the number 1~nums.length is cast at index 0~nums.length-1
        // therefore, the First Missing Positive integer is nums.length+1
        return nums.length+1;
    }
}