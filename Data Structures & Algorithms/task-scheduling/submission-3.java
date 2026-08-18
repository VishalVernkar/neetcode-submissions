class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks){
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int f : freq){
            if(f > 0) maxHeap.offer(f);
        }
        int time = 0;
        Queue<int[]> q = new LinkedList<>(); 
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            } else {
                int count = maxHeap.poll();
                count--;
                if(count > 0) q.offer(new int[]{count, time + n});
            }
            if(!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.offer(q.poll()[0]);
            }
        }
        return time;
    }
}

// we need a max heap - to get the max freq task
// we need a cool down queue - so we don't gat same task again
