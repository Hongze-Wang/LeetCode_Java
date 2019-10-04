package LeetCode;
// 28. Implement strStr()
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if(haystack == "" || needle == "") {
            return 0;
        }
        return haystack.indexOf(needle);
    }
}