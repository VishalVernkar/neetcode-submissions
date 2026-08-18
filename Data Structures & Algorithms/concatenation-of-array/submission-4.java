class Solution {
    public int[] getConcatenation(int[] nums) {

        int[] res = new int[2 * nums.length];
        int i = 2, idx = 0;
        while(i > 0){
            for(int num : nums){
                res[idx++] = num;
            }
            i--;
        }
        return res;
    }
}

// 