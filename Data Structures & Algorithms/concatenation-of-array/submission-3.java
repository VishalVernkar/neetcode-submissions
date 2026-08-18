class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length*2];
        int idx = 0;
        for(int i = 0; i < 2; i++){
            for(int num : nums){
                res[idx++] = num;
            }
        }
        return res;
    }
}

// Question

// 20:40

// 