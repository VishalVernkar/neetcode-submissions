class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int res = 0;
        for(int num : nums){
            int count = 0;
            if(!set.contains(num - 1)){
                while(set.contains(num + count)){
                    count++;
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }
}

// uisng set
// add all the nums
// start the scan from each num if the its next xonsecutive number sexists start the count
