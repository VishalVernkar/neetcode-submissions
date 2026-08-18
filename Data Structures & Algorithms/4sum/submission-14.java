class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            // target -= nums[i];
            for(int j = i + 1; j < n; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                // target -= nums[j];
                int l = j + 1, r = n - 1;
                while(l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    System.out.println(sum);
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++; r--;
                        while(l < r && nums[l] == nums[l - 1]) l++;
                        while(l < r && nums[r] == nums[r + 1]) r--;
                    } else if(sum < target){
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
// 12:23 

// O(n ^ 3 + n log n)