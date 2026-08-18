class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();

        int n = wordList.size();
        int m = wordList.get(0).length();
        for(int i = 0; i < n; i++){
            String s = wordList.get(i);
            for(int j = 0; j < m; j++){
                String ptrn = s.substring(0, j) + "*" + s.substring(j + 1, m);
                graph.computeIfAbsent(ptrn, k -> new ArrayList<>()).add(s);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);

        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                for(int j = 0; j < m; j++){
                    String ptrn = cur.substring(0, j) + "*" + cur.substring(j + 1, m);
                    for(String next : graph.getOrDefault(ptrn, new ArrayList<>())){
                        if(visited.contains(next)) continue;
                        if(next.equals(endWord)) return steps + 1;
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            steps++;
        }

        return 0;
    }
}

// create a graph of words
// using pattern 
// take each replace with * - add that word to the map

// bfs on the given word
// take the word
// get its each pattern 
// get list of words from it
// traverse until we find the word 