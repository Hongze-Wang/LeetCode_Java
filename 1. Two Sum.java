class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length < 2 || nums == null) return null;
        int[] res = {0, 1};
        
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
            }
            map.put(target-nums[i], i);
        }
        return res;
    }
}
