class Solution {
    // create union find class
    private class UnionFind{
        int[] parent;
        int[] rank;
        int n;
        
        private UnionFind(int n){
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        private boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) return false;

            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY];
            } else {
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
            n--;
            return true;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // get MST
        // sort the edges based on weight
        // track the index of edges
        for(int i = 0; i < edges.length; i++){
            edges[i] = Arrays.copyOf(edges[i], 4);
            edges[i][3] = i;
        }

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n);
        int mstWt = 0;
        for(int[] edge : edges){
            if(uf.union(edge[0], edge[1])){
                mstWt += edge[2];
            }
        }

        // get critical and pseudo critical edges
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        for(int[] skip : edges){
            // skip a edge calculate mst
            UnionFind cuf = new UnionFind(n);
            int weight = 0;
            for(int[] edge : edges){
                if(skip[3] != edge[3] && cuf.union(edge[0], edge[1])){
                    weight += edge[2];
                }
            }

            if(cuf.n != 1 || weight > mstWt){
                critical.add(skip[3]);
                continue;
            }

            UnionFind pcuf = new UnionFind(n);
            pcuf.union(skip[0], skip[1]);
            int pweight = skip[2];
            for(int[] edge : edges){
                if(pcuf.union(edge[0], edge[1])){
                    pweight += edge[2];
                }
            }

            if(pweight == mstWt){
                pseudoCritical.add(skip[3]);
            }
        }
    
        List<List<Integer>> res = new ArrayList<>();
        res.add(critical);
        res.add(pseudoCritical);
        return res;
    }
}

// using kruskal's approach
// we need to get MST - weight
// we need to get critical edges
// we need to get pseudo critical edges