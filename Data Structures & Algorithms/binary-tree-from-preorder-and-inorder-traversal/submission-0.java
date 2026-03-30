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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int[] preIndex = {0};
        return buildTree(map, preorder, inorder, preIndex, 0, inorder.length-1);
        
    }

    public TreeNode buildTree(Map<Integer, Integer> map, 
                        int[] preorder, int[] inorder, int[] preIndex, int left, int right) {
        if(left>right) return null;
        int rootVal = preorder[preIndex[0]];
        preIndex[0]++;
        int index = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(map, preorder, inorder, preIndex, left, index-1);
        root.right = buildTree(map, preorder, inorder, preIndex, index+1, right);
        return root;
    }
}
