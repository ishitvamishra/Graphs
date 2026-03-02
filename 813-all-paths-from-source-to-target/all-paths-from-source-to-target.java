class Solution {
    public void dfs(int node, ArrayList<Integer> path, List<List<Integer>> result, int[][] graph){
        path.add(node);

        if(node == graph.length-1){
            result.add(new ArrayList<>(path));
        }

        for(int it : graph[node]){
            dfs(it, path, result, graph);
        }
        path.remove(path.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        dfs(0, path, result, graph);
        
        return result;
    }
}