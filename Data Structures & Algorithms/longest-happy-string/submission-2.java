class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[1] - x[1]);
        if(a > 0) pq.offer(new int[]{'a', a});
        if(b > 0) pq.offer(new int[]{'b', b});
        if(c > 0) pq.offer(new int[]{'c', c});

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(sb.length() > 1 && sb.charAt(sb.length() - 1) == cur[0] && cur[0] == sb.charAt(sb.length() - 2)){
                if(pq.isEmpty()) break;
                int[] next = pq.poll();
                sb.append((char)next[0]);
                next[1]--;
                if(next[1] > 0) pq.offer(next);
            } else {
                sb.append((char) cur[0]);
                cur[1]--;
            }
            if(cur[1] > 0) pq.offer(cur);
        }
        return sb.toString();
    }
}

// 