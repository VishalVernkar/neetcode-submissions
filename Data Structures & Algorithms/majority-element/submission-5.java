class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = -1;
        for(int num:nums){
            if(count == 0){
               res = num;
               count++; 
            } else if(res == num){
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}

// 10:17

// Boyer - moore algorithm
// works if it is guaranteed that there exists a candidtae who exists >n/2 times
// every one has one vote
// if it is a same numbe its vote increses
// if it is a different number the vote reduces
// if it is zero - the new number is the num