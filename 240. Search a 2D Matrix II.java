// 240. Search a 2D Matrix II

// 100& faster
// start from the top-right
// move down to increase or move left to decrease

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int i = 0, j = matrix[0].length-1;
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}

// slightly modified from 74
// 64% faster

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0] == target) return true;
            if(matrix[i][0] < target && matrix[i][matrix[0].length-1] >= target) {
                if(binarySearch(matrix[i], 0, matrix[0].length-1, target)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean binarySearch(int[] array, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(array[mid] == target) {
                return true;
            } else if(array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
