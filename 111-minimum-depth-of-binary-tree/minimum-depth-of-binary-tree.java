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
    public int minDepth(TreeNode root) {
        
        if(root == null) return 0;

        int ld = minDepth(root.left);
        int rd = minDepth(root.right);

        if(root.left == null && root.right == null) return 1;

        if(root.left == null) return 1 + rd;

        if(root.right == null) return 1 + ld;

        return Math.min(ld, rd) + 1;
    }
}