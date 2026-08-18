class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int curPassangers = 0;
        for(int[] trip : trips){
            int from = trip[1];
            int to = trip[2];
            int passangers = trip[0];

            while(!pq.isEmpty() && pq.peek()[0] <= from){
                curPassangers -= pq.poll()[1];
            }

            curPassangers += passangers;
            if(curPassangers > capacity) return false;
            pq.offer(new int[]{to, passangers});
        }
        return true;
    }
}

// sort the array 
// use heap - on short distance - to track on going trips 
// for each from the array
// if the heap is not empty 
// and while the top is <= current start
// pop all from heap - reduce passangers
// add the cur trip passangers
// update it in the heap
// coninue

