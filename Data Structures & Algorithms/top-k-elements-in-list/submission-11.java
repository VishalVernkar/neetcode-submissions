class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqMap = new List[nums.length + 1];

        for(int num : map.keySet()){
            int freq = map.get(num);
            List<Integer> list = freqMap[freq];
            if(list == null){
                list = new ArrayList<>();
                freqMap[freq] = list;
            }
            list.add(num);
        }

        int[] res = new int[k];
        int j = 0;
        for(int i = nums.length; i > 0; i--){
            if(freqMap[i] != null){
                for(int num : freqMap[i]){
                    res[j++] = num;
                    k--;
                    if(k == 0) return res;    
                }
            }
        }


        return null;
    }
}

// top most frequent elements
// 
// brute force
// get the freuency of all elements
// in the hash map
// get the top most using sortin or heap queue
// O(n) + O(k log k)

// frequency map
// 
// frequency as index to the list of numbers
// O(n) + O(n)
