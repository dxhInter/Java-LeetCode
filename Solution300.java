/*
 * @Author: dxhInter dxh0530@gmail.com
 * @Date: 2024-02-27 15:28:36
 * @LastEditors: dxhInter dxh0530@gmail.com
 * @LastEditTime: 2024-02-27 15:45:32
 */

import java.util.Arrays;

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i ; j++){
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = Arrays.stream(dp).max().getAsInt();
        return res;
    }
}