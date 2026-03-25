import java.util.*;

class Solution {
    // Helper class to represent a stack frame for iterative DFS
    private static class Frame {
        int u;          // current node
        int parent;     // parent in DFS tree
        int nextIndex;  // next neighbor index to process
        Frame(int u, int parent, int nextIndex) {
            this.u = u;
            this.parent = parent;
            this.nextIndex = nextIndex;
        }
    }

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] disc = new int[V];   // discovery times, -1 means not visited
        int[] low = new int[V];
        boolean[] articulation = new boolean[V];
        Arrays.fill(disc, -1);
        int time = 0;

        // Iterate over all vertices (graph is connected, but loop handles general case)
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                // Start a new DFS from i as root
                Deque<Frame> stack = new ArrayDeque<>();
                stack.push(new Frame(i, -1, 0));
                int rootChildren = 0;
                int rootNode = i;   // remember the root of this DFS tree

                while (!stack.isEmpty()) {
                    Frame f = stack.peek();
                    int u = f.u;
                    int parent = f.parent;

                    // First time visiting u
                    if (disc[u] == -1) {
                        disc[u] = low[u] = time++;
                    }

                    // Process next neighbor
                    if (f.nextIndex < adj.get(u).size()) {
                        int v = adj.get(u).get(f.nextIndex);
                        f.nextIndex++;

                        // Skip the edge back to parent
                        if (v == parent) continue;

                        if (disc[v] == -1) {
                            // Tree edge
                            if (parent == -1) {
                                rootChildren++; // root's direct child count
                            }
                            stack.push(new Frame(v, u, 0));
                        } else {
                            // Back edge (v already visited and not parent)
                            low[u] = Math.min(low[u], disc[v]);
                        }
                    } else {
                        // All neighbors processed, pop the frame
                        stack.pop();

                        // Post-processing for u
                        if (parent != -1) {
                            // Update parent's low value
                            low[parent] = Math.min(low[parent], low[u]);
                            // Check articulation condition for parent (if parent is not the root)
                            if (parent != rootNode && low[u] >= disc[parent]) {
                                articulation[parent] = true;
                            }
                        } else {
                            // u is the root of this DFS tree
                            if (rootChildren > 1) {
                                articulation[u] = true;
                            }
                        }
                    }
                }
            }
        }

        // Collect articulation points in order
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (articulation[i]) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }
}