class Solution {
    private class DSU{
        int[] parent;
        int[] rank;

        private DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int x){
            if(x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }

        private void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX != rootY) {
                if(rank[rootX] > rank[rootY]){
                    parent[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                } else {
                    parent[rootX] = rootY;
                    rank[rootY] += rank[rootX];
                }
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String, Integer> emailToaccId = new HashMap<>(); 

        // union them
        // find the parent - create the email group
        // finally sort and build the res

        for(int i = 0; i < n; i++){
            List<String> emails = accounts.get(i);
            for(int j = 1; j < emails.size(); j++){
                if(emailToaccId.containsKey(emails.get(j))){
                    dsu.union(emailToaccId.get(emails.get(j)), i);
                } else {
                    emailToaccId.put(emails.get(j), i);
                }
            }
        }

        Map<Integer, List<String>> emailGroup = new HashMap<>(); 
        for(String email : emailToaccId.keySet()){
            int leader = dsu.find(emailToaccId.get(email));
            emailGroup.putIfAbsent(leader, new ArrayList<>());
            emailGroup.get(leader).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for(int accId : emailGroup.keySet()){
            List<String> emails = emailGroup.get(accId);
            Collections.sort(emails);
            emails.add(0, accounts.get(accId).get(0));
            res.add(emails);
        }

        return res;

    }
}

// using union find