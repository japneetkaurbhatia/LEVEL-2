1. knapsack
Recusrsive

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack_(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         if(n == 0 || W == 0) return 0;
         
         if(wt[n - 1] <= W) {
             return Math.max( knapSack_(W, wt, val, n - 1), val[n - 1] + knapSack_(W - wt[n - 1], wt, val, n - 1) );
         } else {
             return knapSack_(W, wt, val, n - 1);
         }
    } 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         return knapSack_(W, wt, val, n);
    } 
}

memoization

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack_(int W, int wt[], int val[], int n, int[][] dp) 
    { 
         // your code here 
         if(n == 0 || W == 0) return dp[n][W] = 0;
         if(dp[n][W] != -1) return dp[n][W];
         if(wt[n - 1] <= W) {
             return dp[n][W] = Math.max( knapSack_(W, wt, val, n - 1, dp), val[n - 1] + knapSack_(W - wt[n - 1], wt, val, n - 1, dp) );
         } else {
             return dp[n][W] = knapSack_(W, wt, val, n - 1, dp);
         }
    } 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n + 1][W + 1];
         for(int i = 0; i < n+1; i++) {
             for(int j = 0; j < W + 1; j++) {
                 dp[i][j] = -1;
             }
         }
         return knapSack_(W, wt, val, n, dp);
    } 
}

Tabulation

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack_(int W, int wt[], int val[], int n, int[][] dp) 
    { 
         // your code here 
         if(n == 0 || W == 0) dp[n][W] = 0;
         
         for(int i = 0; i < n + 1; i++) dp[i][0] = 0;
         for(int j = 0; j < W + 1; j++) dp[0][j] = 0;
         
         for(int i = 1; i < n + 1; i++) {
             for(int j = 1; j < W + 1; j++) {
                 if(wt[i - 1] <= j) {
                    dp[i][j] = Math.max( dp[i - 1][j], 
                    val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
             }
         }
         return dp[n][W];
         
    } 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n + 1][W + 1];
         for(int i = 0; i < n+1; i++) {
             for(int j = 0; j < W + 1; j++) {
                 dp[i][j] = -1;
             }
         }
         return knapSack_(W, wt, val, n, dp);
    } 
}

2. Subset Sum

class Solution{
    
    static Boolean isSubsetSum_(int N, int arr[], int sum, boolean[][] dp){
        // code here
        for(int i = 0; i < N + 1; i++) if(i == 0) dp[0][i] = false;
        for(int j = 0; j < sum + 1; j++) if(j == 0) dp[j][0] = true;
        
        // dp[0][0] = true;
        
        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][sum];
        
    }
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean[][] dp = new boolean[N + 1][sum + 1];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < sum; j++) 
                dp[i][j] = false;
        }
        return isSubsetSum_(N, arr, sum, dp);
    }
}

3. equal sum partition

class Solution {
    private boolean canPartition(int[] nums, int n, int sum, boolean[][] dp) {
        for(int i = 0; i < n ; i++) if(i == 0) dp[0][i] = false;
        for(int i = 0; i <= sum; i++) if(i == 0)  dp[i][0] = true;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]; 
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }        
        
        return dp[n][sum];
    }
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) return false;
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 != 0) return false;
        else {
            boolean[][] dp = new boolean[nums.length + 1][sum/2 + 1];
            for(int i = 0; i < nums.length + 1; i++) {
                for(int j = 0; j < sum/2 + 1; j++) {
                    dp[i][j] = false;
                }
            }
            return canPartition(nums, nums.length, sum/2, dp);  
        } 
    }
}

4. Count of subset sum
recursive

import java.io.*;
import java.util.*;

class GFG {
    public static Scanner scn = new Scanner(System.in);
    public static int countOfSubsets_(int[] arr, int n, int sum) {
        if(n == 0 && sum == 0) return 1;
        if(sum == 0) return 1;
        if(n == 0) return 0;
        
        if(arr[n - 1] <= sum) {
            return countOfSubsets_(arr, n - 1, sum) + countOfSubsets_(arr, n - 1, sum - arr[n - 1]);
        } else {
            return countOfSubsets_(arr, n - 1, sum);
        }
    }
    public static int countOfSubsets(int[] arr, int n , int sum) {
        return countOfSubsets_(arr, n, sum);
    }
	public static void main (String[] args) {
	    int arr[] = {2, 3, 5, 6, 8, 10};
	    int sum = 10;
	    int n = arr.length;
	    int res = countOfSubsets(arr, n, sum);
		System.out.println(res);
	}
}

memoization
