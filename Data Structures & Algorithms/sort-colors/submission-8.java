class Solution {
    public void sortColors(int[] nums) {
        int i = 0, l = 0, r = nums.length - 1;
        while(i <= r){
            if(nums[i] == 0){
                swap(i, l, nums);
                l++;
                i++;
            } else if(nums[i] == 1){
                i++;
            } else {
                swap(i, r, nums);
                r--;
            }
        }
    }

    private void swap(int idx1, int idx2, int[] nums){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}

// 9:46
// using 3 pointers
// i pointer to move along the array
// move the 0 to left pointer
// move the 2 to right pointer