// 1306. Jump Game III

// DFS

// class Solution {
//     public boolean canReach(int[] arr, int start) {
//         if(start >= 0 && start < arr.length && arr[start] >= 0) {
//             if(arr[start] == 0) return true;
//             arr[start] = -arr[start];
//             return canReach(arr, start-arr[start]) || canReach(arr, start+arr[start]);
//         } 
//         return false;
//     }
// }

class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length || arr[start] < 0) return false;
        if(arr[start] == 0) return true;
        arr[start] = -arr[start]; // mark arr[start] as visited
        return canReach(arr, start+arr[start]) || canReach(arr, start-arr[start]);
    }
}


// BFS
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        Queue<Integer> q = new LinkedList();
        q.add(start);
        
        while(!q.isEmpty()) {
            int node = q.poll();
            if(arr[node] == 0) return true;
            if(arr[node] < 0) continue;
            
            if(node + arr[node] < n) {
                q.offer(node + arr[node]);
            }
            if(node - arr[node] >=0) {
                q.offer(node - arr[node]);
            }
            arr[node] = -arr[node];
        }
        return false;
    }
}
