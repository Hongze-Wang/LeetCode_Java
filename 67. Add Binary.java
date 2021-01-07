// 67. Add Binary

class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1, j=b.length()-1;
        int x = 0, y = 0, sum=0, carry = 0;
        StringBuilder sb = new StringBuilder();

        while(i >= 0 || j >= 0) { // 索引可以大于等于0 小细节不要忽视
            x = i < 0 ? 0 : a.charAt(i) - 48;
            y = j < 0 ? 0 : b.charAt(j) - 48;
            sum = x + y + carry;
            carry = sum / 2;
            sum = sum % 2;
            sb.append(sum);
            i--;
            j--;
        }
        if(carry > 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}