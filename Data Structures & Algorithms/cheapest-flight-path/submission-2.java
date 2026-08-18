class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] parent = new int[n];

        Arrays.fill(parent, Integer.MAX_VALUE);
        parent[src] = 0;

        for(int i = 0; i <= k; i++){
            int[] level = Arrays.copyOf(parent, parent.length);
            for(int[] flight:flights){
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if(parent[from] == Integer.MAX_VALUE) continue;

                if(parent[from] + price < level[to]){
                    level[to] = parent[from] + price;
                }
            }
            parent = level;
        }

        return (parent[dst] == Integer.MAX_VALUE)? -1 : parent[dst];
    }
}

// using bellman ford's algorithm
// we bfs from start node
// we relax edges from start - level by level
// we do it k + 1 times
// as we need to take k stops and to reach destination we do +1
// 

// algo 
// start  from start node
// mark other nodes not reachable yet
// we traverse all edges k + 1 times
// the edges that can be reaches - we reach with current weight
// next we again visit each edges
// from each node unlocked - we check if the new dist to current edge is less andupdate
