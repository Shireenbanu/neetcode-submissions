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
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        recursiveIsBalanced(root);
        return flag;
    }

    public int recursiveIsBalanced(TreeNode root){
        int max = 0;
        int left = 0; 
        int right = 0;
        if(root!=null){

            if(root.left != null && flag != false){
               left= recursiveIsBalanced(root.left);
            //    System.out.println(" max on left: "+" for: "+ root.left.val+ " max " + left);
            }

            if(root.right != null && flag != false){
                right = Math.max(max, recursiveIsBalanced(root.right));
                // System.out.println(" max on right: "+" for: "+ root.right.val+ " max " + right);

            }
            
            if(Math.abs(left - right)>1){
                // System.out.println("flag is false;");
                flag = false;
            }

            int res = Math.max(left, right)+1;
            // System.out.println("max for root = "+root.val+ " is "+ res);
            return res;
        }
        return max;
    }
}
