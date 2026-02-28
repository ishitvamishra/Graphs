class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();

        for(String recipe : recipes){
            indegree.put(recipe, 0);
        }

        for(int i = 0; i < recipes.length; i++){
            String recipe = recipes[i];

            for(String ing : ingredients.get(i)){
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
                indegree.put(recipe, indegree.get(recipe) + 1);
            }
        }

        Queue<String> q = new LinkedList<>();
        ArrayList<String> result = new ArrayList<>();

        for(String sup : supplies){
            q.add(sup);
        }

        while(!q.isEmpty()){
            String item = q.poll();

            if(!graph.containsKey(item)) continue;

            for(String nextRecipe : graph.get(item)){
                indegree.put(nextRecipe, indegree.get(nextRecipe) - 1);

                if(indegree.get(nextRecipe) == 0){
                    q.add(nextRecipe);
                    result.add(nextRecipe);
                }
            }
        }
        return result;
    }
}