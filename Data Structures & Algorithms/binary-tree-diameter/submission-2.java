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
    public static int globalMax = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //  System.out.println(encoreDiameter(root));
        globalMax = 0;
        encoreDiameter(root);
        return globalMax;
    }

    public int encoreDiameter(TreeNode root) {
        int max = 0;
        if (root != null) {
            int leftMax = 0;
            int rightMax = 0;
            if (root.left != null) {
                // System.out.println("visitng left: " + root.left.val);
                leftMax = 1 + encoreDiameter(root.left);
            }

            if (root.right != null) {
                // System.out.println("visitng right: " + root.right.val);
                rightMax = 1 + encoreDiameter(root.right);
            }

            max = Math.max(leftMax, rightMax);

            globalMax = Math.max(globalMax, Math.max(max, (leftMax + rightMax)));
            // System.out.println("updated Global: " + globalMax);
        }

        return max;
    }
}
