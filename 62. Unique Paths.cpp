// 62. Unique Paths
class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> arr(m, vector<int>(n, 0));
        
        for(int i=0; i<m; i++) {
            arr[i][0] = 1;
        }
        for(int i=0; i<n; i++) {
            arr[0][i] = 1;
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }
        return arr[m-1][n-1];
    }
};

// Simpler version
class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int> num;
        for(int i=0; i<m; i++) {
            num.push_back(1);
        }
        for(int j=1; j<n; j++) {
            for(int i=1; i<m; i++) {
                num[i] = num[i] + num[i-1];
            }
        }
        return num[m-1];
    }
};
