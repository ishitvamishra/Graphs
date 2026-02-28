class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        // Step 1: Initialize indegree to 0
        for (String recipe : recipes) {
            indegree.put(recipe, 0);
        }

        // Step 2: Build graph and count ALL ingredients
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];

            for (String ing : ingredients.get(i)) {

                // Create edge: ingredient -> recipe
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);

                // Increase indegree of recipe
                indegree.put(recipe, indegree.get(recipe) + 1);
            }
        }

        Queue<String> queue = new LinkedList<>();

        // Step 3: Add all supplies into queue
        for (String supply : supplies) {
            queue.offer(supply);
        }

        List<String> result = new ArrayList<>();

        // Step 4: BFS
        while (!queue.isEmpty()) {

            String item = queue.poll();

            if (!graph.containsKey(item)) continue;

            for (String nextRecipe : graph.get(item)) {

                indegree.put(nextRecipe, indegree.get(nextRecipe) - 1);

                if (indegree.get(nextRecipe) == 0) {
                    result.add(nextRecipe);
                    queue.offer(nextRecipe);
                }
            }
        }

        return result;
    }
}