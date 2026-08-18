class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int m = l + (r - l)/2;
            if(nums[m] == target) return m;
            if(nums[m] < nums[r]){ // we are in sorted part
               if(target > nums[m] && target <= nums[r]){ // does number exist in this sorted part?
                    l = m + 1;
               } else {
                    r = m - 1;
               }
            } else { // we are in rotated part
                // that is nums[m] > nums[r]

                // how nums[m] = nums[r] behaves?
                if(target >= nums[l] && target < nums[m]){ // we check sorted part
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }   

        return -1;
    }
}

// using lower bound?
// 
// mid compared to right?
// 