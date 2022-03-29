1. LC subsequence

memo
class Solution {
    public int longestCommonSubsequence(String str1, String str2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0) return dp[n][m] = 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(str1.charAt(n - 1) != str2.charAt(m - 1)) {
            return dp[n][m] = Math.max(longestCommonSubsequence(str1, str2, n - 1, m, dp),longestCommonSubsequence(str1, str2, n, m - 1, dp));
        } else {
            return dp[n][m] = 1 + longestCommonSubsequence(str1, str2, n-1, m-1, dp);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return longestCommonSubsequence(text1, text2, n, m, dp);
    }
}

tab
class Solution {
    public int longestCommonSubsequence(String str1, String str2, int n, int m, int[][] dp) {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i - 1) != str2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j - 1]);
                } else {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
            }
        }
        
        return dp[n][m];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return longestCommonSubsequence(text1, text2, n, m, dp);
    }
}

2. LC substring
dp
class Solution{
    public int longestCommonSubstr_(String str1, String str2, int n, int m, int[][] dp) {
        int res = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i - 1) != str2.charAt(j - 1)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        
        return res;
    }
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return longestCommonSubstr_(S1, S2, n, m, dp);
    }
}
