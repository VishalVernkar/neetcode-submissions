class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0) maxHeap.offer(new int[]{freq[i], i + 'a'});
        }

        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            if(maxHeap.size() > 1){
                int[] first = maxHeap.poll();
                int[] second = maxHeap.poll();
                sb.append((char) first[1]).append((char) second[1]);
                if(--first[0] > 0) maxHeap.offer(first);
                if(--second[0] > 0) maxHeap.offer(second);
            } else {
                int[] first = maxHeap.poll();
                if(!sb.isEmpty() && sb.charAt(sb.length() - 1) == first[1]) {
                    return "";
                }
                sb.append((char) first[1]);
                if(--first[0] > 0) maxHeap.offer(first);
            }
        }

        return sb.toString();
    }
}

// the max char should always be placed first
// take the first two max chars
// place it next to each other - push them back