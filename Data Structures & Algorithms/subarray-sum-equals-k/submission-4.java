class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}

// brute force - get all the sub arrays - get the sum and count the res
// n^2

// using hash map
// sum upto the num as I go 
// get the diff that'd get us k - see if it exists in the map - get how manuy of them are there - add to the res