class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 0;

        for(int n : nums){
            if(num == n){
                count++;
            } else if(count == 0){
                num = n;
                count++;
            } else {
                count--;
            }
        }

        return num;
    }
}

// boyer moore algo
// if the vote comes to zero
// update the new candidate