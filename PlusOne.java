package LeetCode;
// 66. Plus One
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i;

        for(i = digits.length-1; i >= 0 && digits[i]==9; i--);
        if(i < 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }

        digits[i]++; //general case
        for(i++; i<digits.length; i++) {
            digits[i] = 0;
        }
        return digits;
    }
}
