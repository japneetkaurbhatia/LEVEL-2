class Solution {
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean countSubIslands(int[][] grid1, int[][] grid2, int i, int j, int n, int m) {
        grid2[i][j] = 0;
        boolean res = true;
        for(int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r >= 0 && r < n && c >= 0 && c < m && grid2[r][c] == 1)
                res = countSubIslands(grid1, grid2, r, c, n, m) && res; // *
        }
        return res && grid1[i][j] == 1;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        int ctr = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid2[i][j] == 1) {
                    ctr += countSubIslands(grid1, grid2, i, j, n, m) ? 1 : 0;
                }
            }
        }
        return ctr;
    }
}