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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l1 = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root != null){
            queue.offer(root);
        }
        recursiveList( root, queue, l1);
         return l1;
    }

    public void recursiveList(TreeNode node, Deque<TreeNode> queue, List<List<Integer>> res) {
        if (node != null) {
            TreeNode left = null;
            TreeNode right = null;
            

            while(queue.size()!=0){
                int queueSize = queue.size();
                List<Integer> list = new ArrayList<>();
                for(int i=0; i<queueSize; i++){
                    TreeNode item = queue.poll();
                    list.add(item.val);
                    if(item.left !=null)
                    queue.offer(item.left);

                    if(item.right !=null){
                        queue.offer(item.right);
                    }
                }
                res.add(list);

            }
          
        }
    }
}
