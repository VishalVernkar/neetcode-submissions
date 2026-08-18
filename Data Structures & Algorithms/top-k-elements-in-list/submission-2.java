class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int maxFreq = 0;
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }

        List<Integer>[] freqMap = new List[maxFreq+1];
        for(int key:map.keySet()){
            if(freqMap[map.get(key)] != null){
                freqMap[map.get(key)].add(key);
            } else {
                freqMap[map.get(key)] = new ArrayList<>();
                freqMap[map.get(key)].add(key);
            }
        }

        // System.out.println(Arrays.toString(freqMap));

        int[] res = new int[k];
        for(int i = maxFreq; i > 0; i--){
            if(freqMap[i]!=null){
                for(int num:freqMap[i]){
                    res[--k] = num;
                    if(k==0) return res;
                }
            }

        }
        return res;
    }
    // k most frequent elements
    // using hash map
    // I can frequeny 
    // how to return top k elements
    // put it in array -> sort the array

    
}
