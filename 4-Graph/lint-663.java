public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        int n = rooms.length, m = rooms[0].length;
        if(n == 0 || m == 0)
            return;
        boolean[][] vis = new boolean[n][m];
        
        LinkedList<Integer> que = new LinkedList<>();
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(rooms[i][j] == 0) {
                    vis[i][j] = true;
                    que.addLast(i * m + j);
                }
            }
        }
        
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int idx = que.removeFirst();
                int sr = idx / m, sc = idx % m;
                 
                for (int d = 0; d < 4; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m && rooms[r][c] == 2147483647) {  
                        // vis[r][c] = true; 
                        rooms[r][c] = rooms[sr][sc] + 1;
                        que.addLast(r * m + c);
                    }
                }
            }
        }
        return;
    }
}