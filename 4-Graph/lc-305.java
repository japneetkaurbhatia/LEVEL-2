public int findPar(int u) {
    if(par[u] == u) return u;
    return par[u] = findPar(par[u]);
}

  public List<Integer> numIslands2(int n, int m, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        par = new int[n * m];
        Arrays.fill(par, -1);

        int count = 0;
        for (int[] p : positions) {
            int i = p[0], j = p[1];
            if (par[i * m + j] == -1) {
                count++;
                par[i * m + j] = i * m + j;

                int p1 = findPar(i * m + j);
                for (int d = 0; d < dir.length; d++) {
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m && par[r * m + c] != -1) {
                        int p2 = findPar(r * m + c);
                        if (p1 != p2) {
                            count--;
                            par[p2] = p1;
                        }
                    }
                }
            }
            ans.add(count);
        }

        return ans;
    }