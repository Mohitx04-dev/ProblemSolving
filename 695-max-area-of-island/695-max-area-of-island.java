class Solution {
    public int area(int[][] grid, int i, int j) {
        int ar=0;
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]==0) {
            return 0;
        }
        grid[i][j]=0;
        ar+=1+area(grid,i+1,j)+area(grid,i-1,j)+area(grid,i,j+1)+area(grid,i,j-1);
        return ar;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                area = Math.max(area, area(grid, i, j));
            }
        }
        return area;
    }
}