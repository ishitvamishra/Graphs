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
    public int minimumOperations(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int ans = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int[] level = new int[size];

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                level[i] = node.val;

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            ans += minSwaps(level);
        }

        return ans;
    }

    public int minSwaps(int[] arr){
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(sorted[i] , i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for(int i = 0; i < n; i++){
            if(visited[i] || map.get(arr[i]) == i){
                continue;
            }

            int j = i;
            int cycleSize = 0;

            while(!visited[j]){
                visited[j] = true;
                j = map.get(arr[j]);
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }
}