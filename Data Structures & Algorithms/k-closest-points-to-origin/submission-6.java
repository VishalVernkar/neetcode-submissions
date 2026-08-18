class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        for(int[] point : points){
            int dis = point[0] * point[0] + point[1] * point[1];
            pq.offer(new int[]{dis, point[0], point[1]});
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int idx = 0;
        while(idx < k){
            int[] cur = pq.poll();
            res[idx][0] = cur[1];
            res[idx][1] = cur[2];
            idx++;
        }
        return res;
    }
}
