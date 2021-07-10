public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
     StringBuilder sb;
     int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
     String[] dirS = {"d", "u", "r", "l"};
     public void dfs(int[][] grid, int i, int j, int n , int m) {
         grid[i][j] = 0;         
         for(int d = 0; d < 4; d++) {
             int r = i + dir[d][0];
             int c = j + dir[d][1];
             if(r >= 0 && r < n && c >= 0 && c < m  && grid[r][c] == 1) {
                 sb.append(dirS[d]);
                 dfs(grid, r, c, n , m);  
                sb.append("b");
             }
         }
     }
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here        
        int n = grid.length, m = grid[0].length;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    sb = new StringBuilder();
                    dfs(grid, i, j, n , m);
                    set.add(sb.toString());
                }
            }
        } 
        return set.size();
    }
}