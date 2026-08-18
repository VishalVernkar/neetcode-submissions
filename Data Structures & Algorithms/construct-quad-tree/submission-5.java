/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length);
    }

    private Node dfs(int[][] grid, int r, int c, int n){
        if(n == 1) return new Node(grid[r][c] == 1, true);

        n = n/2;
        Node topLeft = dfs(grid, r, c, n);
        Node topRight = dfs(grid, r, c + n, n);
        Node bottomLeft = dfs(grid, r + n, c, n);
        Node bottomRight = dfs(grid, r + n, c + n, n);

        if(topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val &&
            topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf ) {
                return new Node(topLeft.val, true);
            }

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}

// 9:12
// instead of checking then dividing th quad array.
// we can first divide 
// then while returning the node - we heck if all the nodes are same - and return a leaf node if it is
// or return them sepertley


