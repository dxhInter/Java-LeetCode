/*
 * @Author: dxhInter dxh0530@gmail.com
 * @Date: 2024-02-27 15:47:53
 * @LastEditors: dxhInter dxh0530@gmail.com
 * @LastEditTime: 2024-02-27 16:12:03
 */
public class Solution322 {
    /**
     * 假设amount = 3, coins = [1,2,3] 设F(i)为i的最少的硬币个数
     * F(1) = 1
     * F(2) = 2
     * F(3) = min(F(1),F(2),F(3 - coins[3]) + 1, coins[3] = 3
     *      = min(1,1,0) + 1 
     *      = 1
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if (amount == 0) {
            return 0;
        }
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
            }
        }
        if (dp[amount] == max) {
            return -1;
        }
        return dp[amount];
    }
}
