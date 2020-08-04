// 74. Search a 2D Matrix
// 分行调用二分查找

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0] == target) return true;
            if(matrix[i][0] < target && matrix[i][matrix[0].length-1] >= target) {
                return binarySearch(matrix[i], 0, matrix[0].length-1, target);
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
