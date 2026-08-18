class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int xor){
        if(index == nums.length){
            return xor;
        }

        int include = dfs(nums, index + 1, xor ^ nums[index]);
        int exclude = dfs(nums, index + 1, xor);

        return include + exclude;
    }
}

// 18:59 // 19:20
// 

// 5:51 //

// Question
// get all the combination of sub sets
// find xor for eaxh of them 
// get the total

// there are 2^n combinations - how?
// dfs
// go with all the possibilities with recursion
// return the result