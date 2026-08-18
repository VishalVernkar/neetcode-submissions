class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int val = nums[0];
        for(int num : nums){
            if(val == num){
                count++;
            } else {
                count--;
                if(count == 0){
                    val = num;
                    count = 1;
                }
            }
        }
        return val;
    }
}

// using the boyer - moore voting algorithm
// 