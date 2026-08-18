class FreqStack {
    Map<Integer, Stack<Integer>> map;
    Map<Integer, Integer> freqMap;
    int maxFreq = 0;

    public FreqStack() {
        map = new  HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        map.putIfAbsent(freq, new Stack<>());
        map.get(freq).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        int val = map.get(maxFreq).pop();
        if(map.get(maxFreq).isEmpty()) maxFreq--;
        freqMap.put(val, freqMap.get(val) - 1);

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */

 // freq based stacks
 // freq map to stack
 // freq map - freq of each num
 // 1 - 5, 7, 4
 // 2 - 5, 7 
 // 3 - 5