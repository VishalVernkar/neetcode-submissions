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
        return quadTree(grid, 0, 0, grid.length);
        
    }

    private Node quadTree(int[][] grid, int row, int col, int n){
        if(n == 1){
            return new Node(grid[row][col] == 1, true);
        }

        boolean isSame = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i + row][j + col] != grid[row][col]){
                    isSame = false;
                    break;
                }
            }
        }

        if(isSame){
            return new Node(grid[row][col] == 1, true);
        }

        n = n/2;

        Node topLeft = quadTree(grid, row, col, n);
        Node topRight = quadTree(grid, row, col + n, n);
        Node bottomLeft = quadTree(grid, row + n, col, n);
        Node bottomRight = quadTree(grid, row + n, col + n, n);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);

    }
}

// 14:12 - 14:32

// Question 
// construct a quad tree
// in the given matrix
// until all the divide matrix has same number keep dividing them into 4 quadrants
// if they are same save themas leaf node 

// take the topleft corner of each
// divide size by 2 add to row and columns