class Solution {
    boolean[] used;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum%k != 0) return false;
        used = new boolean[nums.length];
        Arrays.sort(nums);
        reverse(nums);
        return dfs(nums, k, 0, sum/k, 0);
    }

    private void reverse(int[] nums){
        int l = 0, r = nums.length -1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    private boolean dfs(int[] nums, int k, int curSum, int target, int idx){
        if(curSum == target){
            k = k - 1;
            curSum = 0;
            idx = 0;
        }
        if(k == 0) return true;
        for(int i = idx; i < nums.length; i++){
            if(used[i] || curSum + nums[i] > target) continue;
            used[i] = true;
            if(dfs(nums, k, curSum + nums[i], target, idx + 1)) return true;
            used[i] = false;
        }

        return false;
    }
}

// 