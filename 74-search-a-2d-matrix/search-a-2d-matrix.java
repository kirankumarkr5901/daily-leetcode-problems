class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowIndex = 0;
        int low = 0;
        int high = rows-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(matrix[mid][cols-1] == target) return true;
            if(matrix[mid][cols-1] < target) low = mid+1;
            else {
                rowIndex = mid;
                high = mid-1;
            }
        }
        low = 0;
        high = cols-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(matrix[rowIndex][mid] == target) return true;
            if(matrix[rowIndex][mid] < target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}