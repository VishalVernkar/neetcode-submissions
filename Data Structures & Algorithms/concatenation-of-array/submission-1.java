class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = 2 * nums.length;
        int[] res = new int[len];
        int j = 0;
        for(int i=0;i<2;i++){
            for(int num:nums){
                res[j++] = num;
            }
        }
        return res;
    }
}