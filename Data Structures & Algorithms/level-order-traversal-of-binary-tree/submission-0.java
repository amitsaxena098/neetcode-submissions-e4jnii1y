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
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        while(!q.isEmpty()) {
            int s = q.size();
            List<Integer> curr = new ArrayList<>();
            for(int i = 0; i < s; i++) {
                TreeNode node = q.removeFirst();
                curr.add(node.val);
                if(node.left != null) {
                    q.addLast(node.left);
                }
                if(node.right != null) {
                    q.addLast(node.right);
                }
            }
            res.add(curr);
        }
        return res;
    }
}
