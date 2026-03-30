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
    Map<Map<TreeNode, Boolean>, Integer> dp = new HashMap<>();
    public int rob(TreeNode root) {
        return robHouse(root, false);
    }
    public int robHouse(TreeNode root, boolean prev) {
        if(root == null) { return 0; }
        if(dp.containsKey(Map.of(root, prev))) {
            return dp.get(Map.of(root, prev));
        }
        if(!prev) {
            int take = root.val + robHouse(root.left, true) + robHouse(root.right, true);
            int notTake = robHouse(root.left, false) + robHouse(root.right, false); 
            dp.put(Map.of(root, prev), Math.max(take, notTake));
            return Math.max(take, notTake);
        } else {
            int res = robHouse(root.left, false) + robHouse(root.right, false);
            dp.put(Map.of(root, prev), res);
            return res;
        }
    }
}