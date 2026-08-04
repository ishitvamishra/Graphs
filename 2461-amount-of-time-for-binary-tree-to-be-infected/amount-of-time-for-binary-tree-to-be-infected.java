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

    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    TreeNode startNode = null;

    private void buildParent(TreeNode node, TreeNode par, int start) {

        if (node == null)
            return;

        parent.put(node, par);

        if (node.val == start)
            startNode = node;

        buildParent(node.left, node, start);
        buildParent(node.right, node, start);
    }

    public int amountOfTime(TreeNode root, int start) {

        // Build parent map and find start node
        buildParent(root, null, start);

        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        q.offer(startNode);
        visited.add(startNode);

        int time = -1;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                TreeNode curr = q.poll();

                // Left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }

                // Right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }

                // Parent
                if (parent.get(curr) != null && !visited.contains(parent.get(curr))) {
                    visited.add(parent.get(curr));
                    q.offer(parent.get(curr));
                }
            }

            time++;
        }

        return time;
    }
}