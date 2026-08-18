class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int l = 0, r = rows * cols - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            int num = matrix[m/cols][m%cols];
            if(num == target){
                return true;
            } else if(num < target){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}

// we keep the range l = 0 to r = m * n - 1
// to get the index for this number
// to get range 0 to n along the column - for continous j = 0 to 4 along the column - we use mid%col
// to get same number along columns -> for same i = 0 0 0, next row i = 1 1 1 1 - we use mid/col


