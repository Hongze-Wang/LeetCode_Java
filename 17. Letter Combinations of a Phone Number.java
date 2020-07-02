// 17. Letter Combinations of a Phone Number

// class Solution {
//     public List<String> letterCombinations(String digits) {
//         List<String> res = new ArrayList();
//         if(digits == null || digits.length() == 0) return res;
        
//         char[][] map = new char[8][];
//         map[0] = "abc".toCharArray();
//         map[1] = "def".toCharArray();
//         map[2] = "ghi".toCharArray();
//         map[3] = "jkl".toCharArray();
//         map[4] = "nmo".toCharArray();
//         map[5] = "pqrs".toCharArray();
//         map[6] = "tuv".toCharArray();
//         map[7] = "wxyz".toCharArray();
        
//         char[] num = digits.toCharArray();
//         res.add("");
//         for(char c: num) {
//             res = expand(res, map[c-'2']);
//         }
//         return res;
        
//     }
//     private List<String> expand(List<String> res, char[] arr) {
//         List<String> next = new ArrayList();
//         for(String str: res) {
//             for(char c: arr) {
//                 next.add(str + c);
//             }
//         }
//         return next;
//     }
// }

class Solution {
    private String[] map = {
        "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };
    private void combinate(int index, String digits, char[] buffer, List<String> res) {
        if(index == buffer.length) res.add(String.valueOf(buffer));
        else {
            int curNum = digits.charAt(index) - '2';
            for(char c: map[curNum].toCharArray()) {
                buffer[index] = c;
                combinate(index+1, digits, buffer, res);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if(digits == null || digits.length() == 0) return res;
        char[] buffer = new char[digits.length()];
        combinate(0, digits, buffer, res);
        return res;
    }
