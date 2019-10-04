// 167. Two Sum II - Input array is sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        while(low < high) {
            if(numbers[low] + numbers[high] > target) {
                high--;
            } else if(numbers[low] + numbers[high] < target) {
                low++;
            } else {
                return new int[] {low+1, high +1};
            }
        }
        return null;
    }
}