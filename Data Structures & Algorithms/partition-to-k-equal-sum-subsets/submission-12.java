class Solution {
    int[] buckets;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum%k != 0) return false;
        buckets = new int[k];
        Arrays.sort(nums);
        reverse(nums);
        return dfs(nums, 0, sum/k, k);
    }

    private boolean dfs(int[] nums, int idx, int target, int k){
        if(idx == nums.length) return true;

        for(int i = 0; i < k; i++){
            if(buckets[i] + nums[idx] > target) continue;
            buckets[i] += nums[idx];
            if(dfs(nums, idx + 1, target, k)) return true;
            buckets[i] -= nums[idx];
        }

        return false;
    }

    private void reverse(int[] nums){
        int l = 0, r = nums.length - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}