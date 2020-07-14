// 290. Word Pattern

// class Solution {
//     public boolean wordPattern(String pattern, String str) {
//         HashMap map = new HashMap();
//         String[] words = str.split(" ");
        
//         if(words.length != pattern.length()) return false;
        
//         for(Integer i=0; i<words.length; i++) {
//             char c = pattern.charAt(i);
//             String word = words[i];
            
//             if(!map.containsKey(c)) {
//                 map.put(c, i);
//             }
//             if(!map.containsKey(word)) {
//                 map.put(word, i);
//             }
//             if(map.get(c) != map.get(word)) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        
        if(words.length != pattern.length()) return false;
        
        HashMap<Character, String> map_char = new HashMap();
        HashMap<String, Character> map_str = new HashMap();
        
        for(int i=0; i<words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if(!map_char.containsKey(c)) {
                if(map_str.containsKey(w)) {
                    return false;
                } else {
                    map_char.put(c, w);
                    map_str.put(w, c);
                }
            } else {
                if(!map_char.get(c).equals(w)) {
                    return false;
                }
            }
        }
        return true;
    }
}
