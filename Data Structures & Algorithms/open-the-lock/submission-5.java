class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<>();
        if(visited.contains("0000")) return -1;
        q.offer("0000");

        int steps = 0;
        while(!q.isEmpty()){
            for(int i = q.size(); i > 0; i--){
                String lock = q.poll();
                if(target.equals(lock)) return steps;

                for(int j = 0; j < 4; j++){
                    char[] arr = lock.toCharArray();
                    for(int move : new int[]{1, -2}){
                        arr[j] = (char)((arr[j] - '0' + move + 10)%10 + '0');
                        String cur = new String(arr);
                        if(!visited.contains(cur)){
                            visited.add(cur);
                            q.offer(cur);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
        
    }
}

// 5:45 - 6:00

// warmup - next I"ll solve 3 problems
// question - steps - alog - code
// I've to do it through understanding of concept

// Question
// a lock of four wheels
// which we can turn up and down to unlock
// without reaching deadends - that is the minimum steps required to unlock

// steps
// starting from 0000
// each number we can turn up and down
// so at each turn - we have 8 possibility
// we'll collect all those possibily and try them level by level - BFS
// if we encounter, deadends - we don't continue that path in the level - 
// when we turn back we might be visiting the same number - to avoid that we can havae a visited set 