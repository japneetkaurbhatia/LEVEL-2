class Solution {
   public boolean isBipartite(ArrayList<ArrayList<Integer>> graph, int src, int[] vis) {
        vis[src] = 1;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        while(que.size() != 0) {
            int size = que.size();
            while(size-- > 0) {
                int rvtx = que.removeFirst();
                for(int e : graph.get(rvtx)) {
                    if(vis[e] == vis[rvtx])
                        return false;
                    if(vis[e] == -2) {
                        vis[e] = -vis[rvtx];
                        que.addLast(e);
                    }                    
                }               
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();      
        for(int i=0;i<=n;i++){            
            adj.add(new ArrayList<Integer>());
        }        
        for(int i=0;i<dislikes.length;i++){            
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }       
        int[] vis = new int[n+1];
        Arrays.fill(vis, -2);
        for(int i=1;i<=n;i++){            
            if(vis[i]== -2){                
                if(!isBipartite(adj, i, vis)) return false;
            }
        }
        return true;
    }
}