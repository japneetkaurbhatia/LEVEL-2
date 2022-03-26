1. unbounded 

class Solution{
    static int knapSack_(int n, int w, int val[], int wt[], int[][] dp)
    {
        // code here
        if(w == 0 || n == 0) return dp[n][w] = 0;
        if(dp[n][w] != -1) return dp[n][w];
        if(wt[n - 1] <= w) {
            return dp[n][w] = Math.max(val[n - 1] + knapSack_(n, w - wt[n - 1], val, wt, dp), knapSack_(n - 1, w, val, wt, dp));
        } else {
            return dp[n][w] = knapSack_(n - 1, w, val, wt, dp);
        }
        
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] dp = new int[N + 1][W + 1];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return knapSack_(N, W, val, wt, dp);
    }
}

2. Rod Cutting Problem

class Solution{
    public int cutRod_(int price[], int[] len, int n, int w, int[][] dp) { 
        if(n == 0) return dp[n][w] = 0;
        if(w == 0) return dp[n][w] =  0;
        if(dp[n][w] != -1) return dp[n][w];
        if(len[n - 1] <= w) {
            return dp[n][w] = Math.max(cutRod_(price, len, n - 1, w, dp), 
            price[n - 1] + cutRod_(price, len, n, w - len[n-1], dp) );
        } else {
            return dp[n][w] = cutRod_(price, len, n - 1, w, dp);
        }
    }
    public int cutRod(int price[], int n) {
        //code here
        int[] len = new int[n];
        int val = 1;
        for(int i = 0; i < n; i++) len[i] = i+1;
        int[][] dp = new int[n + 1][n + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return cutRod_(price, len, n, n, dp);
    }
}

3. Coin Change : Max no of ways

memo:

class Solution {
    private int coinWays(int[] arr, int n, int amt, int[][] dp) {
        if(n == 0 && amt == 0) return dp[n][amt] = 1;
        if(amt == 0) return dp[n][amt] = 1;
        if(n == 0 && amt != 0) return dp[n][amt] = 0;
        if(dp[n][amt] != -1) return dp[n][amt];
        if(arr[n -1] <= amt) {
            return dp[n][amt] = coinWays(arr, n - 1, amt, dp) + coinWays(arr, n, amt - arr[n - 1], dp);
        } else {
            return dp[n][amt] = coinWays(arr, n - 1, amt, dp);
        }
        
    }
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return coinWays(coins, n, amount, dp);
    }
}

tab:

class Solution {
    private int coinWays(int[] arr, int n, int amt, int[][] dp) {
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < amt + 1; j++) {
                if(j == 0) dp[i][j] = 1;
                if(i == 0 && j != 0) dp[i][j] = 0;
                if(i == 0 && j == 0) dp[i][j] = 1;
            }
        }
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < amt + 1; j++) {
                if(arr[i -1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][amt];        
    }
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return coinWays(coins, n, amount, dp);
    }
}

3. Coin Change : Min no of coins needed

class Solution {
    private int coinWays(int[] arr, int n, int amt, int[][] dp) {
        for(int j = 0; j < n + 1; j++) {
            dp[j][0] = 0;
        }
        
        for(int i = 0; i < amt + 1; i++){
            dp[0][i] = (int)1e9 - 1; 
        }
        
        for(int i = 1; i <= amt; i++){
            if(i % arr[0] == 0){
                dp[1][i] = i / arr[0];
            }else{
                dp[1][i] = (int)1e9 - 1; 
            }   
        }
        
        for(int i = 2; i<=n; i++) {
            for(int j = 1; j<=amt; j++) {
                if(arr[i-1] <=j) {
                    dp[i][j] = Math.min(1 + dp[i][j - arr[i-1]], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        
        return dp[n][amt] == (int)1e9 - 1 ? -1 : dp[n][amt];        
    }
    
    public int coinChange(int[] coins, int amount) {
        // if(amount == 0) return ;
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return coinWays(coins, n, amount, dp);
    }
}
