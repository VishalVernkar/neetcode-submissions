class Solution {
    public int removeDuplicates(int[] nums) {
        // as it is sorted array the next duplicates can be ignored
        int idx = 0;
        nums[idx++] = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]) continue;
            nums[idx++] = nums[i];
        }
        return idx;
    }

}