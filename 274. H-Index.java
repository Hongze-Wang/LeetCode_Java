// 274. H-Index

// class Solution {
//     public int hIndex(int[] citations) {
//         if(citations.length == 1) {
//             if(citations[0] == 0) return 0;
//             else return 1;
//         }
        
//         int counter=0;
//         Arrays.sort(citations);
//         for(int i=citations.length-1; i>=0; i--) {
//             if(citations[i] > counter) counter++;
//         }
//         return counter;
//     }
// }

// class Solution {
//     public int hIndex(int[] citations) {
//         int counter = 0;
//         for(int i=citations.length-1; i>=0; i--) {
//             if(citations[i] >= length - i) {
//                 counter++;
//             } else {
//                 break;
//             }
//         }
//         return counter;
//     }
// }

// class Solution {
//     public int hIndex(int[] citations) {
//         Arrays.sort(citations);
//         for(int i=0; i<citations.length; i++) {
//             if(citations[i] >= citations.length-i) {
//                 return citations.length-i;
//             }
//         }
//         return 0;
//     }
// }

class Solution {
    public int hIndex(int[] citations) {
        int[] bucket = new int[citations.length+1];
        for(int i=0; i<citations.length; i++) {
            bucket[Math.min(citations[i], citations.length)]++;
        }
        for(int i=citations.length, count=0; i >=0; i--) {
            count += bucket[i];
            if(count >= i) return i;
        }
        return 0;
    }
}
