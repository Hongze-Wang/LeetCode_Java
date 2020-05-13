// 16. 3Sum Closest
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        if (n<3) return 0;
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        int mid = 0, high=0, res = 0, x = 0, y = 0;
        for(int low=0; low < n-2; low++) {
            mid=low+1;
            high=n-1;
            x = target - nums[low];
            while(mid < high) {
                y = nums[mid] + nums[high];
                if(y > x) {
                    high--;
                } else if(y < x) {
                    mid++;
                } else {
                    return target;
                }
                if(Math.abs(nums[low] + y - target) < Math.abs(diff)){
                    res = nums[low] + y;
                    diff = nums[low] + y - target;
                }
            }
        }
        return res;
    }
}