/*
 * @Author: dxhInter dxh0530@gmail.com
 * @Date: 2024-02-24 16:59:59
 * @LastEditors: dxhInter dxh0530@gmail.com
 * @LastEditTime: 2024-02-24 17:10:39
 */
class Solution70{
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}