class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] parent = new int[n];
        Arrays.fill(parent, Integer.MAX_VALUE);
        parent[src] = 0;
        for(int i = 0; i <= k; i++){
            int[] level = Arrays.copyOf(parent, parent.length);
            for(int[] flight : flights){
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if(parent[from] == Integer.MAX_VALUE) continue;

                if(price + parent[from] < level[to]){
                    level[to] = price + parent[from];
                }
            }
            parent = level;
        }

        return (parent[dst] == Integer.MAX_VALUE)? -1 : parent[dst];
    }
}

// using bellman's for algorithm
// it is like BFS
// we start a - one starting point - a node
// from that node - we relax its adjacent ones
// we relax v - 1 => times in normal bellman's for finding negative cycles
// here we relax k + 1 times
// as we can take only k stops 
// we start - we take k stops - we move one more time to reach destination

// algo
// we use a array to keep track of which node we can relax
// we relax edges k + 1 times
// so for k + 1 times - we visit evrey edge and relax ones - we can
// we relax step by step - level by level
// so we update the current level - based on it's previous level 
// we don't update based on current level itself - which will affect the stops - we have to track
// 

// we use infi - on every vertices
// we start src node - with zero
// if it is not infi and the current weight + current dist from src to dist < the dist so far
// if true we update

// after k + 1 - times - we return the dist[target]