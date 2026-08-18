class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);
        for(int i = 0; i < capital.length; i++){
            minHeap.offer(i);
        }

        while(k > 0){
            k--;
            while(!minHeap.isEmpty() && capital[minHeap.peek()] <= w){
                maxHeap.offer(minHeap.poll());
            }
            if(maxHeap.isEmpty()) return w;
            w += profits[maxHeap.poll()];
        }
        return w;
    }
}

// we need to take the projects capital <= current capital - among them prick the project with greater profit 
// one heap to get the capital <= w
// one heap to load the avaialble projects for the current cap and get the maxProfit