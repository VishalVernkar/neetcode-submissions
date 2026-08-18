class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}

// 11:14

// we have a sorted array -> remove duplicates
// ins = 0
// nums[i] != nums[i - 1] -> insert 