class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int m = l + (r - l)/2;
            if(nums[m] == target) return m;
            if(nums[m] < target){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }
}

// [-1,0,2,4,6,8]
//   0 1 2 3 4 5 
// 0 - 5
// m = 2

// 3 - 5
// m = 4

// 3 - 3