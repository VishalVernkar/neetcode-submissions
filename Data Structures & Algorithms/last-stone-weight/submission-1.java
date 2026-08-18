class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int stone : stones){
            pq.offer(stone);
        }

        while(pq.size() > 1){
            int res = Math.abs(pq.poll() -  pq.poll());
            if(res > 0) pq.offer(res);
        }

        return (pq.size() == 0)? 0 : pq.poll();
    }
}
