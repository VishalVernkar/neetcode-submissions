class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        int degree = 0;
        for(int i = 1; i < words.length; i++){
            String w1 = words[i - 1], w2 = words[i];
            if(w1.length() > w2.length() && w1.startsWith(w2)) return "";
            int n = Math.min(w1.length(), w2.length());
            for(int j = 0; j < n; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    if(!graph.get(w1.charAt(j)).contains(w2.charAt(j))){
                        graph.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                        degree++;
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(char c : indegree.keySet()){
            if(indegree.get(c) == 0) q.offer(c);
        }

        System.out.println(graph);

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            for(char nc : graph.get(cur)){
                degree--;
                indegree.put(nc, indegree.get(nc) - 1);
                if(indegree.get(nc) == 0){
                    q.offer(nc);
                }   
            }
        }

        System.out.println(sb.toString());
        return (degree == 0)? sb.toString() : "";
    }
}
