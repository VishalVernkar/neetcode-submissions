class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 1;
        int n = nums.length;

        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i - 1]){
                nums[l++] = nums[i];
            }
        }
        return l;
    }
}