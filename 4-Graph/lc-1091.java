class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n == 0) return -1;
        if(n == 1 && grid[0][0] == 1) return 1;
        if(grid[0][0] == 0 || grid[n - 1][n -1] == 0) return -1;
        LinkedList<Integer> que = new LinkedList<>();
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int sp = 1;
        que.addLast(0);
         while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int idx = que.removeFirst();
                int sr = idx / n, sc = idx % n;                            
                for (int d = 0; d < 4; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];q
                    if (r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 1) {  
                        if(r == n-1 && c == n - 1) return sp + 1;
                        grid[r][c] = 1; 
                        que.addLast(r * n + c);
                    }
                }
            }
             sp++;
        }
        return -1;
    }
}