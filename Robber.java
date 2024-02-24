/*
 * @Author: dxhInter dxh0530@gmail.com
 * @Date: 2024-02-24 17:19:09
 * @LastEditors: dxhInter dxh0530@gmail.com
 * @LastEditTime: 2024-02-24 17:26:57
 * @FilePath: \Java-LeetCode\Robber.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
public class Robber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1 ) {
            return nums[0];
        }
        dp[0] = nums[0];
        // dp数组代表到第i户最多能抢多少钱，所以dp[1]需要nums[0] and nums[1] 最大值
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
