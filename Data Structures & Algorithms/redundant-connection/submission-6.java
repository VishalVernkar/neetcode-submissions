class Solution {
    private class DSU{
        int[] parent;
        int[] rank;

        private DSU(int n){
            parent = new int[n + 1];
            rank = new int[n + 1];
            for(int i = 1; i <= n; i++){
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

            if(rootX == rootY) return true;

            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY];
            } else {
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }

            return false;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);

        for(int[] edge:edges){
            if(dsu.union(edge[0], edge[1])) return new int[]{edge[0], edge[1]};
        }

        return null;
    }
}

// using union find
// the two sets if already has common parents should not have same parents again
