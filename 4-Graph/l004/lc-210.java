class Solution {
    public int[] findOrder(int N, int[][] arr) {
        ArrayList<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();
        for (int[] a : arr) {
            graph[a[0]].add(a[1]);
        }

        LinkedList<Integer> que = new LinkedList<>();
        int[] ans = new int[N];
        int[] indegree = new int[N];
        int idx = N - 1;

        // O(E)
        for (int i = 0; i < N; i++) {
            for (Integer v : graph[i]) {
                indegree[v]++;
            }
        }

        // O(V)
        for (int i = 0; i < N; i++)
            if (indegree[i] == 0)
                que.addLast(i);

        // O(E + V)
        while (que.size() != 0) {
            int rvtx = que.removeFirst();
            ans[idx--] = rvtx;

            for (Integer v : graph[rvtx]) {
                if (--indegree[v] == 0)
                    que.addLast(v);
            }
        }

        if (idx != -1)
            ans = new int[0];

        return ans;
    }

}