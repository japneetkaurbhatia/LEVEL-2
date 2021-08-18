class Solution {
     public int dfs_gcc(int[][] grid, int i, int j, int[][] dir) {
        grid[i][j] = 0;
        int m = grid.length, n = grid[0].length;
        int size = 0;
        for(int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1)
                size += dfs_gcc(grid, r, c, dir);
        }
         return size + 1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int islandSize = 0;
        int m = grid.length, n = grid[0].length;
        int[][] dir =  {{1,0},{-1,0},{0,-1},{0,1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int s = dfs_gcc(grid, i,j, dir);
                    islandSize = Math.max(islandSize, s);
                }   
            }
        }
        return islandSize;
    }
}