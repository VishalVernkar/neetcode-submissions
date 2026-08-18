class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> res = new HashMap<>();
       for(int num:nums){
            res.put(num, res.getOrDefault(num,0) + 1);
       } 

       List<Integer>[] freq = new List[nums.length+1];

       res.forEach((key, value) -> {
            if(freq[value] == null) freq[value] = new ArrayList<>();
            freq[value].add(key);
       });

       int[] ans = new int[k];
       k=0;
       for(int i=freq.length - 1; i >= 0; i--){
            if(freq[i] != null){
                for(int num: freq[i]){
                   if(k<ans.length){
                        ans[k++] = num;
                   } else {
                        break;
                   }
                }
            }
       } 

       return ans;
    }
}
