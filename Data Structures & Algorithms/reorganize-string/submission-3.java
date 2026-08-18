class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0) maxHeap.offer(new int[]{i, freq[i]});
        }

        int n = s.length();
        if(maxHeap.peek()[1] > (n + 1)/2) return "";

        StringBuilder res = new StringBuilder();

        while(maxHeap.size() > 1){
            int[] char1 = maxHeap.poll();
            int[] char2 = maxHeap.poll();

            res.append((char) (char1[0] + 'a'));
            res.append((char) (char2[0] + 'a'));

            if(--char1[1] > 0) maxHeap.offer(char1);
            if(--char2[1] > 0) maxHeap.offer(char2);
        }

        if(!maxHeap.isEmpty()){
            int[] char1 = maxHeap.poll();
            if(char1[1] > 1) return "";
            res.append((char) (char1[0] + 'a'));
        }

        return res.toString();

    }
}


// 20:42 // 21:00

// priority queue - having the char to max freq
// take each char

// max freq
// a - 1
// b - 2
// c - 2
// d - 2
// dbdb  

// 9:14 - 9:24

// Question
// we need to proritze the top two max frequent  
// we take it - arrange them next to each other -  put them back in heap
// 