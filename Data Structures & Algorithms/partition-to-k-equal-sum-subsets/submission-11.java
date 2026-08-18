class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % k != 0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, k, used, target, 0);
    }

    private boolean backtrack(int[] nums, int k, boolean[] used, int target, int curSum) {
        if(k == 0) {
            // System.out.println("k " + k + " " + curSum);
            return true;
        }

        if(curSum == target) {
            // System.out.println("k " + k + " " + curSum);
            if(backtrack(nums, k - 1, used, target, 0)) return true;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            if(nums[i] + curSum > target) break;
            used[i] = true;
            if(backtrack(nums, k, used, target, curSum + nums[i])) return true;
            used[i] = false;
            if(curSum == 0) break;
        }

        return false;
    }
}

// 4:10 - 4:20

// divide the array into k parts and its all parts sum must be equal
// if possible return true

// using buckets - to - k equal sum - is slow  - as k acn be bigger - grows exponential
// what bucket does is it tries all the parts - with all the numbers at same time

// where as for each number - check if it can form a equal part - tries to build one part at a time 
// if it fails - it stops

// try one set of numbers if I find target sum move to next set
// use boolean array - to prevent from using used nums
// 

// algo
// sort the array - to make it easy for early pruning
// if  I have enough subsets I've the all the parts equal
// if the sum == target - I've one set
// for each number 
//  if it is more than target - continue
//  add to the sum move
//  backtrack
//  pruning - if cur sum is zero no combination was possible start with this number - I'll watch video of this to understand better

















// I've to write the alogrithm
// Every sec - minute is useful
// No stimulation - no thinking - don't follow thoughts - observe - myself
// No need to follow perfectio in beutifying code



// It is like those initial days, where seeing proof takes time - but I've go to keep working on it 
// - I believe this works - The next thing I've to do is - strenghtn this belief
// for that consistency is important - otherwise it is fragile or vulnarable - it is easier to fall back to self doubt
// 