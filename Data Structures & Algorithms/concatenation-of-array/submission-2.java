class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2*n];
        int idx = 0;
        for(int i=0;i<2;i++){
            for(int num:nums){
                res[idx++] = num;
            }
        }
        return res;
    }
}

// create an array where it contains duplicate of it at end of the array