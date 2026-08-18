public class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums);
        return res;
    }

    private void dfs(int i, int[] nums) {
        if (i == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            res.add(temp);
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[i]) continue;
            swap(nums, i, j);
            dfs(i + 1, nums);
        }
        
        //Instead of a single swap-back inside the main loop, this loop runs after all branches for position i are explored. 
        //It shifts the elements back to their original sorted relative order. 
        //This ensures that when the recursion returns to a higher level, the array is still "predictable" (sorted), 
        //which is what makes the nums[j] == nums[i] check effective.

        for (int j = nums.length - 1; j > i; j--) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}