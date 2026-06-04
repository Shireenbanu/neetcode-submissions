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
    public TreeNode invertTree(TreeNode root) {
        
       invertTreeLevelOrder(root);
        
        return root;
    }

    public void invertTreeLevelOrder(TreeNode root){
        TreeNode left = null;
        TreeNode right = null;

        if(root != null){
            
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left!= null)
            invertTreeLevelOrder(root.left);
            if(root.right!=null)
            invertTreeLevelOrder(root.right);
        }   
    }
}
