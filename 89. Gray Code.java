// 89. Gray Code

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> code = new ArrayList<>();
        
        for (int i = 0; i < 1 << n; i++) {
            code.add(i ^ (i >> 1));
        }

        return code;
    }
}

// class Solution {
//     public List<Integer> greyCode(int n) {
//         List<Integer> code = new ArrayList<>();
//         code.add(0);
//         for(int mask=0; mask<n; mask++) {
//             for(int prev=code.size()-1; prev>=0; prev--) {
//                 code.add((1 << mask) | code.get(prev));
//             }
//         }
//         return code;
//     }
// }
