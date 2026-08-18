class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int r = n - 1;
        int l = 0;

        if (l == r && nums[l] == target) return true; 

        while(l < r){
            int m = l + (r - l)/2;
            if(nums[m] == target) return true;

            while(l < r && nums[m] == nums[r]) r--;
            while(l < r && nums[m] == nums[l]) l++;
            if(nums[l] == target) return true;
            if(nums[r] == target) return true;

            // left is sorted
            if(nums[l] < nums[m]){
                if(nums[l] < target && target < nums[m]){
                    r = m;
                } else {
                    l = m + 1;
                }
            } else { // right is sorted
                if(nums[m] < target && target < nums[r]){
                    l = m + 1;
                } else {
                    r = m;
                }
            }
        }
        return false;
    }
}
//  0 1 2 3 
// [1,1,3,1] tar = 3
// l = 0
// r = 3
// m = 1 
// m -> 1
// r -> 2

// [1,2,3,4,5,6,7]


// 10:32 - 10:52
// Question
// Search in sorted but rotated array

// Binary search 
// which side to move boundaries left and right

// 0 1 2 3 4 5 6 7
// 3,4,4,5,6,1,2,2 -> target 1
// 3,4,4,5,6    1,2,2

// left = 0
// right = 7
// mid = 3
// mid -> 5

// if value exist between left and mid
// right = mid - 1;
// else 
// left = mid + 1; 

// Duplicates - How to handle it?
// if left part has duplicates?
// move by step 1 until no longer duplicates are there

// brute force
// Identify sorted part
// check if the number lies in sorted part
// else move to other side

// how to find sorted part
// mid can exist in left sorted or right sorted
// if(left < mid) left is sorted
// if(mid < right) right is sorted
// 