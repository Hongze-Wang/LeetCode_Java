// 18. 4Sum
// two pointers
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length < 4) return new ArrayList();
        Arrays.sort(nums);
        if(nums[0] * 4 > target) return new ArrayList();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length; j++) {
                if(j > i+1 && nums[j]==nums[j-1]) continue;
                int low = j+1;
                int high = nums.length-1;
                while(low < high) {
                    if(low-1 > j && nums[low] == nums[low-1]) {
                        low++;
                        continue;
                    }
                    if(nums[i] + nums[j] + nums[low] + nums[high] < target) {
                        low++;
                    } else if(nums[i] + nums[j] + nums[low] + nums[high] > target) {
                        high--;
                    } else {
                        // List<Integer> list = new ArrayList();
                        // list.add(nums[i]);
                        // list.add(nums[j]);
                        // list.add(nums[low]);
                        // list.add(nums[high]);
                        // res.add(list);
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                    }
                }
            }
        }
        return res;
    }
}