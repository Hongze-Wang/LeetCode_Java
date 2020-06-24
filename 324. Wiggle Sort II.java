// 324. Wiggle Sort II

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int mid = (nums.length-1) / 2, right = nums.length - 1, counter = 0;
        int[] res = new int[right+1];
        while(mid >=0 || right > (nums.length-1) / 2) {
            if(counter % 2 == 0) {
                res[counter] = nums[mid];
                mid--;
            } else {
                res[counter] = nums[right];
                right--;
            }
            counter++;
        }
        for(int i=0; i<nums.length; i++) {
            nums[i] = res[i];
        }
    }
}
