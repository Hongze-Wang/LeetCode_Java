package LeetCode;
// 38. Count and Say
public class CountandSay {
    public String countAndSay(int n) {
        if(n==1) {
            return "1";
        }
        String res = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<res.length()) {
            int count=0;
            char last = res.charAt(i);
            while(i<res.length() && res.charAt(i)==last) {
                i++;
                count++;
            }
            sb.append(count).append(last);
        }
        return sb.toString();
    }
}
