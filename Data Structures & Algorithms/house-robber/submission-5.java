class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for(int num : nums){
            int cur = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = cur;
        }

        return Math.max(rob1, rob2);
    }
}

// at a point to come here
// which is best
// rob the current house + rob (i - 2)  or rob (i - 1)