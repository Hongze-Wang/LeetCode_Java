package LeetCode;
import java.util.HashMap;
import java.util.Map;
// 1. Two Sum
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> result = new HashMap<>();
        int[] indexes = {0 ,1};

        if(nums.length > 2) {
            for(int i=0; i<nums.length; i++) {
                if(result.containsKey(nums[i])) {
                    indexes[0] = result.get(nums[i]);
                    indexes[1] = i;
                }
                int remainder = target - nums[i];
                result.put(remainder, i);
            }
        }
        return indexes;
    }
}
