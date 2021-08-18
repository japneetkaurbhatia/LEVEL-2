public class l002_StringSet {

    // LC 516
    public int lpss(String s, int si, int ei, int[][] dp) {
        if(si >= ei) {
            return dp[si][ei] = (si == ei) ? 1 : 0;
        }

        if(dp[si][ei] != 0)
            return dp[si][ei];

        if(s.charAt(si) != s.charAt(ei))
            dp[si][ei] = Math.max(lpss(s, si + 1, ei, dp), lpss(s, si, ei - 1, dp));
        else
            dp[si][ei] = lpss(s, si + 1, ei - 1, dp) + 2;

        return dp[si][ei];
    }

    public int lpss_DP(String s, int SI, int EI, int[][] dp) {
        int n = s.length();
        for(int gap = 0; gap < n; gap++) {
            for(int si = 0, ei = gap; si < n; si++, ei--) {
                if(si >= ei) {
                    dp[si][ei] = (si == ei) ? 1 : 0;
                    continue;
                }

                if(s.charAt(si) != s.charAt(ei))
                    dp[si][ei] = Math.max(dp[si+1][ei], dp[si][ei-1]);
                else
                    dp[si][ei] = dp[si+1][ei-1] + 2;
            }
        }
        return dp[SI][EI];
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return lpss(s, 0, n - 1, dp);
    }
}