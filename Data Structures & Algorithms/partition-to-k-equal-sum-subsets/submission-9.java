class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        reverse(nums);
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum%k != 0) return false;
        int target = sum / k;

        int[] parts = new int[k];

        return backtrack(nums, parts, 0, target);
    }

    private boolean backtrack(int[] nums, int[] parts, int idx, int target) {
        if(idx == nums.length) {
            return true;
        }

        int num = nums[idx];
        for(int i = 0; i < parts.length; i++){
            if(parts[i] + num > target) continue;
            parts[i] += num;
            if(backtrack(nums, parts, idx + 1, target)) return true;
            parts[i] -= num;
        }
        return false;
    }

    private void reverse(int[] nums){
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }

}

// 20:49
// this is permutation problem 
// where we need to place the elements in given k places - whose sum is equal

// I can do it based on last problem I solved - which i match sticks to square

// algo
// boolean back track
// if i == len return true
// else 
// from place 0 to k
// try all permutations