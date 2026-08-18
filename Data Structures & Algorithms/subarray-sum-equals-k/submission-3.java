class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0, 1);
       int curSum = 0;
       int res = 0;
       for(int num : nums){
            curSum += num;
            int diff = curSum - k;
            if(map.containsKey(diff)) res += map.get(diff);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
       }
       return res;
    }
}

// 11:22

// prefix sum
// hash map
// 

// 2 -1 1 2
// 2 
// 2 - 2 = 0
// 0, 1
// get all the sum and if the same sum encountered somewhere increment it
// if i find that diff again - I get the count of it and add it to the res