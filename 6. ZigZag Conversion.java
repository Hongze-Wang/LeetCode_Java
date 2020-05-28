// 6. ZigZag Conversion

// Brute Force: use 2D stringbuilder to imitate the whole process
// other method is pretty hard to come across
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        
        List<StringBuilder> rows = new ArrayList();
        for(int i=0; i<Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goDown = false;
        
        for(char c: s.toCharArray()) {
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows-1) goDown = !goDown;
            curRow += goDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row: rows) res.append(row);
        return res.toString();
    }
}


// Using the 1st solution if you are in a interview
/*For all whole numbers kk,

Characters in row 00 are located at indexes k \; (2 \cdot \text{numRows} - 2)k(2⋅numRows−2)
Characters in row \text{numRows}-1numRows−1 are located at indexes k \; (2 \cdot \text{numRows} - 2) + \text{numRows} - 1k(2⋅numRows−2)+numRows−1
Characters in inner row ii are located at indexes k \; (2 \cdot \text{numRows}-2)+ik(2⋅numRows−2)+i and (k+1)(2 \cdot \text{numRows}-2)- i(k+1)(2⋅numRows−2)−i.

*/
// class Solution {
//     public String convert(String s, int numRows) {
//         if(numRows == 1) return s;
//         StringBuilder res = new StringBuilder();
//         int n = s.length();
//         int cycle = 2 * numRows - 2;
//         for(int i=0; i<numRows; i++) {
//             for(int j=0; j+i<n; j+=cycle) {
//                 res.append(s.charAt(j+i));
//                 if(i != 0 && i != numRows -1 && j + cycle - i < n) {
//                     res.append(s.charAt(j+cycle-i));
//                 }
//             }
//         }
//         return res.toString();
//     }
// }
