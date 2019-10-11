// 205. Isomorphic Strings

// 更多解法见python解法

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        char[] ch1 = new char[128];
        char[] ch2 = new char[128];
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        int length = s.length();

        for(int i=0; i < length; i++) {
            if(ch1[str1[i]] != '\0' || ch2[str2[i]] != '\0') {
                if(ch2[str2[i]] != str1[i]) {
                    return false;
                }
            } else {
                ch1[str1[i]] = str2[i];
                ch2[str2[i]] = str1[i];
            }
        }
        return true;
    }
}