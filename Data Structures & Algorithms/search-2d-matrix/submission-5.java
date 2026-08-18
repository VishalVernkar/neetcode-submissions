class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = (m * n) - 1;

        while(l <= r){
            int mid = l + (r - l) / 2;
            int i = mid/n;
            int j = mid%n;
            if(matrix[i][j] == target){
                return true;
            } 

            if(matrix[i][j] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}


// 0 to 11
// m = 5
// i , j
// i - 5/4 -> 1
// j - 5%4 -> 1 - 1

//   0 1 2 3 4 5 6 7 8 9 10 11 
// i 0 0 0 0 1 1 1 1 2 2 2  2
// j 0 1 2 3 0 1 2 3 0 1 2 3 
// 6/4 - 1