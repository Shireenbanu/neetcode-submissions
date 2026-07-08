/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<Integer> line = new ArrayDeque<>();
        int res = recursiveSearch(root, line, k);
        return res;
    }

    public int recursiveSearch(TreeNode root, Deque<Integer> stack, int k) {
        int res = -1;

        if (root != null) {
            if (root.left != null) {
                res = recursiveSearch(root.left, stack, k);
            }

            if (res == -1) {
                // System.out.println(" " + root.val);
                stack.push(root.val);

                if (stack.size() == k) {
                    res = stack.pop();
                    // System.out.println("Its time to pop: " + res);
                }
            }

            if (root.right != null && res == -1) {
                res = recursiveSearch(root.right, stack, k);
            }
        }

        return res;
    }
}
