class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i-1] == nums[i]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j-1] == nums[j]) continue;
                double currTarget = (double)target - nums[i] - nums[j];
                int l = j+1;
                int r = n-1;
                while(l<r){
                    double sum = nums[l] + nums[r];
                    if(sum == currTarget){
                        res.add(Arrays.asList(nums[i] , nums[j] , nums[l] , nums[r]));
                        l++;
                        r--;
                        while(l<r && nums[l-1] == nums[l])l++;
                        while(l<r && nums[r-1] == nums[r])r--;
                    } else if(sum < currTarget){
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

//nums[a] + nums[b] + nums[c] + nums[d] = target
