class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int val = nums[0];
        for(int num:nums){
            if(count == 0){
                val = num;
                count++;
            }else if(val == num){
                count++;
            }else{
                count--;
            }
        }
        return val;
    }
}