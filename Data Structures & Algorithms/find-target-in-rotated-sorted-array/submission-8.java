class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(target == nums[m]) return m;

            if(nums[l] <= nums[m]){
                if(target >= nums[l] && target < nums[m]){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if(target <= nums[r] && target > nums[m]){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
// 1.
// find peak 
// search on left or right

// 2.
// compare to left side
// check which side we are one
// update the 
