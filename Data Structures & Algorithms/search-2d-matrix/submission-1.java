class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = (m * n) - 1;
        int midRow = 0, midCol = 0;
        while(l<=r){
            int mid = l + (r - l)/2;
            midRow = mid / n;
            midCol = mid % n;
            int num = matrix[midRow][midCol];
            if(num == target){
                return true;
            } else if(num < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
