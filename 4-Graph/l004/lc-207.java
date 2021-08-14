class Solution {
      public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        for (int[] a : prerequisites) {
            graph[a[0]].add(a[1]);
        }

        LinkedList<Integer> que = new LinkedList<>();
        int[] ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        int idx = numCourses - 1;

        // O(E)
        for (int i = 0; i < numCourses; i++) {
            for (Integer v : graph[i]) {
                indegree[v]++;
            }
        }

        // O(V)
        for (int i = 0; i < numCourses; i++)
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

        return ans.length == numCourses;
    }
}