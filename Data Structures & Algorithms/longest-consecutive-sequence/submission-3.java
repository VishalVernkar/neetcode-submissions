class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        for(int num : nums){
            int count = 0;
            if(!set.contains(num - 1)){
                int next = num;
                while(set.contains(next)){
                    count++;
                    next++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}

// uisng hash set
// we populate the set
// we start from each num 
// if the num has prev we don't start count
// if it is not we start count we store max
           
