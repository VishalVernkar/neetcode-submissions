class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            for(char c : words[i].toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 1; i < words.length; i++){
            String w1 = words[i - 1], w2 = words[i];
            if(w1.length() > w2.length() && w1.startsWith(w2)) return "";
            int len = Math.min(w1.length(), w2.length());
            for(int j = 0; j < len; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    if(!graph.get(w1.charAt(j)).contains(w2.charAt(j))){
                        graph.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(char c : indegree.keySet()){
            if(indegree.get(c) == 0){
                q.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char c = q.poll();
            sb.append(c);
            for(char nc : graph.get(c)){
                indegree.put(nc, indegree.get(nc) - 1);
                if(indegree.get(nc) == 0){
                    q.offer(nc);
                }
            }
        }

        return (sb.length() != indegree.size())? "" : sb.toString();
    }   
}


// create a graph of char's - by comparing adjacent words - the chars at which word differ is place we coonect chars
// we get the topological sort of the graph
// as - it is good if the graph is disconnected and visits evey node