class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                pq.offer(new int[]{ i + 97, freq[i]});
            }
        }
        int[] prev = null;
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty() || prev != null){
            if(!pq.isEmpty()){
                int[] cur = pq.poll();
                sb.append((char)cur[0]);
                cur[1]--;
                if(prev != null) pq.offer(prev);
                if(cur[1] > 0) prev = cur;
                else prev = null;
            } else {
                if(sb.charAt(sb.length() - 1) == prev[0] || prev[1] > 1){
                    return "";
                } 
                sb.append((char) prev[0]);
                break;
            }
        }
        return sb.toString();
    }
}
// 

// if it is same char return