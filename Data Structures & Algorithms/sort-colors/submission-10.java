class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        while(i <= r){
            if(nums[i] == 2){
                nums[i] = nums[r];
                nums[r] = 2;
                r--;
            } else if(nums[i] == 0){
                nums[i] = nums[l];
                nums[l] = 0;
                l++;
                i++;
            } else {
                i++;
            }
        }
    }
}

// as we have three colors 
// we can move all the 2 to end
// all the 0 to start 
// eventually 1 ends up in the middle