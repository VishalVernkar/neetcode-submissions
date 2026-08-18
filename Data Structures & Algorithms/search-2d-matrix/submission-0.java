class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = (m * n) - 1;
        int midRow = 0, midCol = 0;
        while(l<=r){
            int mid = l + (r - l)/2;
            if(mid>=n){
                midRow = mid / n;
                midCol = mid % n;
            } else {
                midRow = 0;
                midCol = mid;
            }
            int num = matrix[midRow][midCol];
            System.out.println(num);
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

// approach -binary search
// how to get elements o=in linear format?
// 1 - create new array 
//     and search in it
//     O(log(m * n)) + (m * n) for creating array and extra space

// 2 - compute index


// 3 - search in each row
//     T => m * log n

//      0   1  2  3 
//   0 [1 , 2, 4, 8]
//   1 [10,11,12,13]
//   2 [14,20,30,40]

//   n = 12;  
//   l = [0][0]  r = [2][3]
//   mid = l + (r - l)/2 
//   => if it was 1d array (0 + 11)/2 = 5 => 11 => [1][1]

//   midRow = 1
//   midCol = 1
//   => this works

//   10, 11
//   r = [midRow][midCol - 1] = [1][0]

//   midRow = [0]
//   midCol = [0] -> this doesn't 
  
//   l = 0, r = 11  
//   m = 5
//   5 > 4
//   row 5/4 = 1
//   col 5 - 5/4 = 1

//  10 11
//  r = m - 1 = 4
//  l = 0
 
//  m = 2
//  r = 0, col = 2
//  4 10
//  l = 3
// r = 4

// m = 3
// r = 0, col = 3
// 8 10
// l = 4
// r = 4

// m = 4
// 4 = ncols
// ro = 1, col = 0
// 10 == 10 return res





