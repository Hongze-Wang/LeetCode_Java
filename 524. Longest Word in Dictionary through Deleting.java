// 524. Longest Word in Dictionary through Deleting

// Brute Force 
// Memory Limit Exceeded

// class Solution {
//     public String findLongestWord(String s, List<String> d) {
//         if(s == null || d == null) return null;
        
//         HashSet<String> set = new HashSet<>(d);
//         List<String> list = new ArrayList<>();
//         String max_str ="";
        
//         generate(s, "", 0, list);
//         for(String str : list) {
//             if(set.contains(str)) {
//                 if(str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0)) {
//                     max_str = str;
//                 }
//             }
//         }
//         return max_str;
//     }
//     private void generate(String s, String str, int i, List<String> list) {
//         if(i == s.length()) {
//             list.add(str);
//         } else {
//             generate(s, str+s.charAt(i), i+1, list);
//             generate(s, str, i+1, list);
//         }
//     } 
// }

// Sorting then two pointers
// class Solution {
//     public boolean isSubsequence(String x, String y) {
//         int j=0;
//         for(int i=0; i<y.length() && j<x.length(); i++) {
//             if(x.charAt(j) == y.charAt(i)) {
//                 j++;
//             }
//         }
//         return j==x.length();
//     }
//     public String findLongestWord(String s, List<String> d) {
//         Collections.sort(d, (s1, s2) -> s2.length() != s1.length() ? s2.length()-s1.length() : s1.compareTo(s2));
//         // Collections.sort(d, new Comparator<String> () {
//         //    public int compare(String s1, String s2) {
//         //        return s2.length() != s1.length() ? s2.length()-s1.length() : s1.compareTo(s2);
//         //    } 
//         // });
//         for(String str : d) {
//             if(isSubsequence(str, s)) {
//                 return str;
//             }
//         }
//         return "";
//     }
// }

class Solution {
    public boolean isSubsequence(String x, String y) {
        int j=0;
        for(int i=0; i<y.length() && j<x.length(); i++) {
            if(x.charAt(j) == y.charAt(i)) {
                j++;
            }
        }
        return j==x.length();
    }
    public String findLongestWord(String s, List<String> d) {
        String max_str = "";
        for(String str : d) {
            if(isSubsequence(str, s)) {
                if(str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0)) {
                    max_str = str;
                }
            }
        }
        return max_str;
    }
}
