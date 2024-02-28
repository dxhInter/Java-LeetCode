/*
 * @Author: dxhInter dxh0530@gmail.com
 * @Date: 2024-02-27 22:57:58
 * @LastEditors: dxhInter dxh0530@gmail.com
 * @LastEditTime: 2024-02-27 23:41:58
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                TreeNode tmp = null;
                if (node.left != null) {
                    queue.offer(node.left);
                    tmp = node.left;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                node.left = node.right;
                node.right = tmp;
                size --;
            }
        }
        return root;
    }

    public TreeNode invertTreeRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTreeRecursion(root.left);
        TreeNode right = invertTreeRecursion(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
