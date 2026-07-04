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
    public boolean isValidBST(TreeNode root) {
        Deque<Integer> dq = new ArrayDeque<>();
        boolean flag = recursiveBST(root, dq);
        return flag;
    }

    public boolean recursiveBST(TreeNode root, Deque<Integer> dq) {
        boolean flag = true;
        if (root != null) {
            if (root.left != null && flag!=false) {
               flag = recursiveBST(root.left, dq);
            }
            // System.out.print(root.val+ " ");

            if (dq.size() > 0) {
                // System.out.println(dq.peek() + " " + root.val);
                if ((dq.peek()) >= (root.val)) {
                    flag = false;
                    return flag;
                }
            }
            dq.push(root.val);
            // System.out.println("dq.peek() " + dq.peek());
            if (root.right != null && flag!=false) {
                flag = recursiveBST(root.right, dq);
            }
        }

        return flag;
    }
}
