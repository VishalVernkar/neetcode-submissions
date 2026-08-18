class Solution {
    public void sortColors(int[] nums) {
        int one = 0, two = 0, zero = 0;
        int n = nums.length;
        for(int i = 0; i < n;i++){
            if(nums[i] == 0){
                nums[two++] = 2;
                nums[one++] = 1;
                nums[zero++] = 0;
            } else if(nums[i] == 1){
                nums[two++] = 2;
                nums[one++] = 1;
            } else {
                nums[two++] = 2;
            }
        }
    }
}