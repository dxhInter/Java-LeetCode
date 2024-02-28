/*
 * @Author: dxhInter dxh0530@gmail.com
 * @Date: 2024-02-27 21:00:22
 * @LastEditors: dxhInter dxh0530@gmail.com
 * @LastEditTime: 2024-02-27 21:00:25
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution104 {
    /**
     * 递归, DFS
     * @param root
     * @return
     */
    public int maxDepthWithRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepthWithRecursion(root.left);
            int rightHeight = maxDepthWithRecursion(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 基于队列，BFS
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
                size --;
            }
            res ++;
        }
        return res;
    }
}
