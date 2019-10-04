package LeetCode;
// 136. Single Number

// Using HashSet
//class Solution {
//    public int singleNumber(int[] nums) {
//        if(nums == null || nums.length < 1) return 0;
//
//        Set<Integer> set = new HashSet<>();
//        for(int num: nums) {
//            if(set.contains(num)) {
//                set.remove(num);
//            } else {
//                set.add(num);
//            }
//        }
//        return set.iterator().next();
//    }
//}

// Using XOR
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
