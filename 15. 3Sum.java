// 15. 3Sum
// three pointers + binary serach
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 二分法应用条件

        for(int low=0; low < nums.length-2; low++) {
            int mid = low+1, high = nums.length-1, sum = -nums[low];
            if(sum < 0) {
                break;
            }
            if(low != 0 && nums[low] == nums[low-1]) {
                continue;
            }
            while(mid < high) {
                if(nums[mid] + nums[high] == sum) {
                    res.add(Arrays.asList(nums[low], nums[mid], nums[high]));
                    while((mid < high) && (nums[mid] == nums[mid+1])) {
                        mid++;
                    }
                    while((mid < high) && (nums[high] == nums[high-1])) {
                        high--;
                    }
                    mid++;
                    high--;
                } else if(nums[mid] + nums[high] < sum) {
                    mid++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }