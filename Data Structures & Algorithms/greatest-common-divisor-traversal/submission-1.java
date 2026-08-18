class Solution {
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

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> factors = new HashMap<>();

        for(int i = 0; i < n; i++){
            int num = nums[i];
            int f = 2;
            while(f * f <= num){
                if(num%f == 0){
                    if(factors.containsKey(f)){
                        uf.union(i, factors.get(f)); 
                    } else {
                        factors.put(f, i);
                    }
                    while(num%f == 0) num /= f;
                }
                f++;
            }
            if(num > 1){
                if(factors.containsKey(num)){
                    uf.union(i, factors.get(num)); 
                } else {
                    factors.put(num, i);
                }
            }
        }
        return uf.n == 1;
    }
}

// 0 -> 2 <-> 1

// 

// if the two pair from i to j - has gcd > 1
// then they are connected create a graph 
// the graph is undirected
// if all the indexes are connected it means - we reach any from any so
// we can use union find - to get the res
// if all the components are conected - we return true

// we create a union find class - track noumber of connected components
// we have to get the gcd 
// we use prime factors
// to get prime factore
// we try factors <= sqrt(num) => f * f <= num
// we have to divide the current prime factor - to clear it
// then we try next factor 
// at the end if num > 1 - it is a prime - we use it
// we use map of prime factor to a number
// union it every time if exists 
// else we add it to map