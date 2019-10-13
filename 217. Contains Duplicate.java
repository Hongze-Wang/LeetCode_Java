// 217. Contains Duplicate

// 直观解法 但不是效率最高的
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return false;
        }
        
        HashSet<Integer> set = new HashSet(nums.length);
        for(int i=0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}

// 96% faster
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) return false;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}

// 99.45% faster 98.25 memory less
// 改变for循环的写法并不能加速

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i: nums) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        int[] arr = new int[(max - min)/32 + 1];
        for (int i: nums) {
            int x = i - min;
            int pos = x / 32;
            int mask = 1 << (x % 32);
            if ((arr[pos] & mask) != 0) {
                return true;
            } else {
                arr[pos] |= mask;
            }
        }
        return false;
    }
}