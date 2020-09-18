// 557. Reverse Words in a String III

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder w = new StringBuilder();
        for(String str : words) {
            w.append(str);
            sb.append(w.reverse());
            sb.append(" ");
            w.setLength(0);
        }
        return sb.toString().trim();
    }
}

// class Solution {
//     public String reverseWords(String s) {
//         if(s == null || s.length() < 2) return s;
//         StringBuilder sb = new StringBuilder();
//         StringBuilder w = new StringBuilder();
//         for(int i=0; i<s.length(); i++) {
//             if(s.charAt(i) != ' ') {
//                 w.append(s.charAt(i));
//             } else {
//                 sb.append(w.reverse());
//                 sb.append(" ");
//                 w.setLength(0);
//             }
//         }
//         sb.append(w.reverse());
//         return sb.toString();
//     }
// }
