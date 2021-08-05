class Solution {
    public boolean isBipartite(int[][] graph, int src, int[] vis) {
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        int color = 0;
        while(que.size() != 0) {
            int size = que.size();
            while(size-- > 0) {
                int rvtx = que.removeFirst();
                if(vis[rvtx] != -1) {
                    if(vis[rvtx] != color) {
                        return false;
                    }
                    continue;
                }
                
                vis[rvtx] = color;
                for(int e : graph[rvtx]) {
                    if(vis[e] == -1)
                        que.addLast(e);
                }
            }
            color = (color + 1)% 2;
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; 
        int[] vis = new int[n];
        Arrays.fill(vis, -1);        
        for (int i = 0; i < n; i++) {
            if (vis[i] == -1 && !isBipartite(graph, i, vis))
                return false;
        }        
        return true;
        // return isBipartite(graph,0,vis);
    }
}