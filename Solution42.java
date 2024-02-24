/*
 * @Author: dxhInter dxh0530@gmail.com
 * @Date: 2024-02-23 20:08:17
 * @LastEditors: dxhInter dxh0530@gmail.com
 * @LastEditTime: 2024-02-23 23:12:59
 */

import java.util.Deque;
import java.util.LinkedList;

public class Solution42 {
    public int trap2Points(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        left ++;
        right --;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans = ans + leftMax - height[left];
                left ++;
            }else{
                ans = ans + rightMax - height[right];
                right --;
            }
        }
        return ans;
    }

    public int trapDP(int[] height){
        if (height.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[height.length - 1] = height[height.length-1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        for (int i = 0; i < rightMax.length; i++) {
            ans = ans + (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return ans;
    }

    public int trapStack(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.size() == 0) {
                    break;
                }
                int iLeft = stack.peek();
                int weight = i - iLeft -1;
                int high = Math.min(height[i], height[iLeft]) - height[top];
                ans += weight * high;
            }
            stack.push(i);
        }
        return ans;
    }
}