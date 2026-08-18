class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[nums.length];
        for(int i = 0; i<=r;i++){
            if(nums[i] == 2){
                nums[i] = nums[r];
                nums[r] = 2;
                r--;
                i--;
            } else if(nums[i] == 0){
                nums[i] = nums[l];
                nums[l] = 0;
                l++;
            }
        }
    }
}

//uisng counting sort
// O(n + n)

// Do it in one pass
// using two pointers
// whatever 2 we encounter we push it to end and push the umber from it to strat