class Pair {
    String gene;
    int steps;

    Pair(String gene, int steps) {
        this.gene = gene;
        this.steps = steps;
    }
}

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        // Convert bank to HashSet
        Set<String> set = new HashSet<>(Arrays.asList(bank));

        // If endGene not present in bank → impossible
        if (!set.contains(endGene)) return -1;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startGene, 0));   // start from 0 mutations

        char[] genes = {'A', 'C', 'G', 'T'};

        while (!q.isEmpty()) {

            Pair current = q.poll();
            String gene = current.gene;
            int steps = current.steps;

            // If reached target
            if (gene.equals(endGene)) return steps;

            // Try mutating each position
            for (int i = 0; i < gene.length(); i++) {

                for (char ch : genes) {
                    
                    char[] arr = gene.toCharArray();
                    arr[i] = ch;
                    String newGene = new String(arr);

                    if (set.contains(newGene)) {
                        set.remove(newGene);          // mark visited
                        q.add(new Pair(newGene, steps + 1));
                    }
                }
            }
        }

        return -1;   // if no path found
    }
}