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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = dfs(root);
        return res;
        
    }
    public String dfs(TreeNode root) {
        if(root == null) return "N,";

        String res = String.valueOf(root.val);
        res = res.concat(",");
        String left = dfs(root.left);
        String right = dfs(root.right);
        return res + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = {0};
        String[] data2 = data.split(",");
        return dfs(data2, index);
    }
    public TreeNode dfs(String[] data, int[] index) {
        if(index[0] > data.length || data[index[0]].equals("N")) {
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(data[index[0]]));
        index[0]++;
        root.left = dfs(data, index);
        root.right = dfs(data, index);
        return root;

    }
}
