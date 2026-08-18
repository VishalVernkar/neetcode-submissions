class FreqStack {
    Map<Integer, Integer> map;
    List<Stack<Integer>> freqMap;
    int maxFreq = 0;

    public FreqStack() {
        map = new HashMap<>();
        freqMap = new ArrayList<>();
        freqMap.add(new Stack<>());
    }
    
    public void push(int val) {
        int freq = map.getOrDefault(val, 0) + 1;
        map.put(val, freq);
         
        if(freqMap.size() <= freq){
            maxFreq++;
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            freqMap.add(stack);
        } else {
            freqMap.get(freq).push(val);
        }
    }
    
    public int pop() {
        int res = freqMap.get(maxFreq).pop();
        map.put(res, map.get(res) - 1);
        if(freqMap.get(maxFreq).isEmpty()){
            freqMap.remove(maxFreq);
            maxFreq--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */

 //13:42

 // HashMap - for frequency of the vals
 // list of stack - to store the freq - values
 // maxFreq - to get the most freq element
 // 

 // insertion - update in the map
 // get the frequency - push it to that freq stack


 // pop
 // get the stack from max frequency
 // remmove top element
 // reduce it's count
 // if the list stack becomes empty reduc the maxFreq 