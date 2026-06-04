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
    
    public int maxDepth(TreeNode root) {
        int max = 0;
        if(root!=null){
        max = maxDepthInOrderTraversal(root, max+1);
        }
        return max;
    }

    public int maxDepthInOrderTraversal(TreeNode root, int max){
        int left = 0;
        int right = 0;
        if(root!=null){
            if(root.left!=null){
              left = maxDepthInOrderTraversal(root.left, max+1);
            }
            if(root.right!=null){
              right = maxDepthInOrderTraversal(root.right, max+1);
            }
        }
        int currMax  = Math.max(max, Math.max(left,right));

        // System.out.println("After root: "+ root.val +" max = "+currMax);

        return currMax;
    }
}
