package LeetCode;
// 58. Length of Last Word
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if(s==null || s.isEmpty()) return 0;
        s = s.trim();

        int index = s.lastIndexOf(" ");
        index = index >=0 ? index+1 : 0;
        return s.substring(index).length();
    }
}
