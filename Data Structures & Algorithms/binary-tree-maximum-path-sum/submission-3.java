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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }
    public int maxPath(TreeNode root) {
        if(root == null) return 0;

        int left = maxPath(root.left);
        int right = maxPath(root.right);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        max = Math.max(root.val + left + right, max);

        return root.val + Math.max(left, right);
    }
}
