/*
 * @Author: dxhInter 592310050@qq.com
 * @Date: 2024-02-29 15:50:48
 * @LastEditors: dxhInter 592310050@qq.com
 * @LastEditTime: 2024-02-29 16:20:30
 */
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution105 {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int index4Inorder = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[index4Inorder]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[index4Inorder]) {
                    node = stack.pop();
                    index4Inorder ++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    public TreeNode buildTreeReverse(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, n-1, 0, n-1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if (preorder_left > preorder_right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int inorder_root = indexMap.get(preorder[preorder_left]);
        int left_tree_nums = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = buildTreeHelper(preorder, inorder, preorder_left + 1, preorder_left + left_tree_nums, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = buildTreeHelper(preorder, inorder, preorder_left + left_tree_nums + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}