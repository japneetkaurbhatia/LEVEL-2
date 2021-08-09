public class l001_TwoPointer {
    
    public static void display(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] arr) {
        for (int[] ar : arr) {
            display(ar);
        }
        System.out.println();
    }

    // 1. Fibonacci
    // F(n) = F(n - 1) + F(n - 2)
    public static int fibo_memo(int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = n;
        }

        if (dp[n] != 0)
            return dp[n];

        int ans = fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
        return dp[n] = ans;
    }

    public static int fibo_tabu(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];// fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
            dp[n] = ans;
        }

        return dp[N];
    }

    public static int fibo_opti(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void fibo_Set(){
        int n = 5;
        int[] dp = new int[n + 1];
        // System.out.println(fibo_memo(n, dp));
        // System.out.println(fibo_tabu(n, dp));
        System.out.println(fibo_opti(n));

        display(dp);
    }

    // 2 Maze Path
    // move in h(0,1) d(1,1) v(1,0) 
    // total no of path from each cell 

    public static int mazePath(int sr, int sc, int er, int ec, int[][] dir, int[][] dp) {
        if(sr == er && sc == ec) {
            return dp[sr][sc] = 1;              // got 1 path
        }

        if(dp[sr][sc] != 0) return dp[sr][sc];

        int steps = 0;
        for(int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r >= 0 & c >= 0 && r <= er && c <= ec) {
                steps += mazePath(r,c,er,ec,dir, dp);
            }
        }
        return dp[sr][sc] = steps;
    }

    public static int mazePath_tab(int SR, int SC, int er, int ec, int[][] dir, int[][] dp) {
        for(int sr = er; sr >= SR; sr--) {
            for(int sc = ec; sc >= SC; sc--) {
                if(sr == er && sc == ec) {
                    dp[sr][sc] = 1;  
                    continue;            // got 1 path
                }

                int steps = 0;
                for(int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if(r >= 0 & c >= 0 && r <= er && c <= ec) {
                        steps += dp[r][c]; //mazePath(r,c,er,ec,dir, dp);
                    }
                }
                dp[sr][sc] = steps;

            }
        }
        return dp[SR][SC];        
    }

    public static int mazePathJump(int sr, int sc, int er, int ec, int[][] dir, int[][] dp) {
        if(sr == er && sc == ec) {
            return dp[sr][sc] = 1;              // got 1 path
        }

        if(dp[sr][sc] != 0) return dp[sr][sc];

        int steps = 0;
        for(int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            while(r <= er && c <= ec) {
                steps += mazePathJump(r,c,er,ec,dir, dp);
                r += dir[d][0];
                c += dir[d][1];
            }
        }
        return dp[sr][sc] = steps;
    }

    public static int mazePathJump_tab(int SR, int SC, int er, int ec, int[][] dir, int[][] dp) {
        for(int sr = er; sr >= SR; sr--) {
            for(int sc = ec; sc >= SC; sc--) {
                if(sr == er && sc == ec) {
                    dp[sr][sc] = 1;  
                    continue;            // got 1 path
                }

                int steps = 0;
                for(int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    while(r <= er && c <= ec) {
                        steps += dp[r][c]; //mazePath(r,c,er,ec,dir, dp);
                        r += dir[d][0];
                        c += dir[d][1];
                    }
                }
                dp[sr][sc] = steps;
            }
        }
        return dp[SR][SC];        
    }

    public static void mazePath_Set() {
        int sr = 0, sc = 0;
        int n = 3, m = 3;
        int[][] dp = new int[n][m];
        int[][] dir = {{0,1}, {1,0}, {1,1}};
        // System.out.println(mazePath(sr,sc, n- 1, m- 1, dir, dp));
        // System.out.println(mazePath_tab(sr,sc, n- 1, m- 1, dir, dp));
        System.out.println(mazePathJump_tab(sr,sc, n- 1, m- 1, dir, dp));
        display2D(dp);
    }

    public static void main(String[] args){
        // fibo_Set();
        mazePath_Set();
    }
}