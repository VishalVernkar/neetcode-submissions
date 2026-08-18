class FreqStack {
    Map<Integer, Integer> cntMap;
    List<Stack<Integer>> freqStack;

    public FreqStack() {
        cntMap = new HashMap<>();
        freqStack = new ArrayList<>();
        freqStack.add(new Stack<>());
    }
    
    public void push(int val) {
        int valCnt = cntMap.getOrDefault(val, 0) + 1;
        cntMap.put(val, valCnt);
        if(valCnt == freqStack.size()){
            freqStack.add(new Stack<>());
        }
        freqStack.get(valCnt).push(val);
    }
    
    public int pop() {
        Stack<Integer> topStack = freqStack.get(freqStack.size() - 1);
        int val = topStack.pop();
        cntMap.put(val, cntMap.get(val) - 1);
        if(topStack.isEmpty()){
            freqStack.remove(freqStack.size() - 1);
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */

 // 10:45 // 11:05

 // pop() removes and returns the most frequent element in the stack
 // how to track the most frequent element
 // 
 // stack of stacks?