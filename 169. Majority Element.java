// 169. Majority Element

class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int preVal = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == preVal) count++;
            else {
                count--;
                if(count == 0) {
                    preVal = nums[i];
                    count = 1;
                }
            }
        }
        return preVal;
    }
}

// Using Array.sort()
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}