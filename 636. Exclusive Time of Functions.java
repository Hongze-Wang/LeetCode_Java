// 636. Exclusive Time of Functions

// Standard Solution time limit exceeded

// class Solution {
//     public int[] exclusiveTime(int n, List<String> logs) {
//         Stack<Integer> stack = new Stack();
//         int[] res = new int[n];
//         String[] s = logs.get(0).split(":");
//         stack.push(Integer.parseInt(s[0]));
//         int i=1, time = Integer.parseInt(s[2]);
//         while(i < logs.size()) {
//             s = logs.get(i).split(":");
//             while(time < Integer.parseInt(s[2])) {
//                 res[stack.peek()]++;
//                 time++;
//             }
//             if(s[1].equals("start")) {
//                 stack.push(Integer.parseInt(s[0]));
//             } else {
//                 res[stack.peek()]++;
//                 time++;
//                 stack.pop();
//             }
//             i++;
//         }
//         return res;
//     }
// }

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i=1, prev = Integer.parseInt(s[2]);
        while(i < logs.size()) {
            s = logs.get(i).split(":");
            if(s[1].equals("start")) {
                if(!stack.empty()) {
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                }
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2])+1;
            }
            i++;
        }
        return res;
    }
}

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack();
        int res[] = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 0, prev = Integer.parseInt(s[2]);
        while(i < logs.size()) {
            s = logs.get(i).split(":");
            if(s[1].equals("start")) {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1; // end at the end of Integer.parseInt(s[2]) + 1
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1; // begin at the start of Integer.parseInt(s[2]) + 1
            }
            i++;
        }
        return res;
    }
}
