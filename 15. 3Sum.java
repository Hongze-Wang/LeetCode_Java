// 15. 3Sum

// two pointers / slide window
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int low=0; low < nums.length-2; low++) {
            int i = low+1, high = nums.length-1, sum = -nums[low];
            if(sum < 0) {
                break;
            }
            if(low != 0 && nums[low] == nums[low-1]) {
                continue;
            }
            while(i < high) {
                if(nums[i] + nums[high] == sum) {
                    res.add(Arrays.asList(nums[low], nums[i], nums[high]));
                    while((i < high) && (nums[i] == nums[i+1])) {
                        i++;
                    }
                    while((i < high) && (nums[high] == nums[high-1])) {
                        high--;
                    }
                    i++;
                    high--;
                } else if(nums[i] + nums[high] < sum) {
                    i++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}
