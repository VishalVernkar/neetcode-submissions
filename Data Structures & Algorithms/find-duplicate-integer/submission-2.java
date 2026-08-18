class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(fast != slow);

        int slow2 = 0;
        do{
            slow = nums[slow];
            slow2 = nums[slow2];
        } while(slow2 != slow);

        return slow;
    }
}


// fist fine the cycle


// start slow from start and meet point - the point at which they meet is the duplicate
