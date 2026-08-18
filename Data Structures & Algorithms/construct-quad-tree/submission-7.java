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
        // keep dividing all the grid in to 4 quadrants till it acn't be divided any more if the 
        return quadTree(grid, 0, 0, grid.length);
    }

    private Node quadTree(int[][] grid, int i, int j, int n){
        if(n == 1) return new Node(grid[i][j] == 1, true);
        n = n / 2;
        Node topLeft =  quadTree(grid, i, j, n);
        Node topRight =  quadTree(grid, i, j + n, n);
        Node bottomLeft =  quadTree(grid, i + n, j, n);
        Node bottomRight =  quadTree(grid, i + n, j + n, n);

        if(topLeft.isLeaf && topRight.isLeaf && bottomRight.isLeaf && bottomLeft.isLeaf &&
            topLeft.val == topRight.val && 
            topRight.val == bottomLeft.val &&
            bottomLeft.val == bottomRight.val) return topLeft;

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
