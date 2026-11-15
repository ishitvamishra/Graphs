class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int it : friends[i]) {
                adj.get(i).add(it);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<String> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];

        q.add(id);
        vis[id] = true;

        int currLevel = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (currLevel == level) {

                HashMap<String, Integer> mpp = new HashMap<>();

                for (int i = 0; i < size; i++) {
                    int node = q.poll();

                    List<String> vid = watchedVideos.get(node);

                    for (String it : vid) {
                        mpp.put(it, mpp.getOrDefault(it, 0) + 1);
                    }
                }

                TreeMap<Integer, List<String>> tm = new TreeMap<>();

                for (String video : mpp.keySet()) {
                    int freq = mpp.get(video);

                    tm.putIfAbsent(freq, new ArrayList<>());
                    tm.get(freq).add(video);
                }

                for (int freq : tm.keySet()) {
                    List<String> videos = tm.get(freq);

                    Collections.sort(videos);
                    ans.addAll(videos);
                }

                break;
            } else {
                for (int i = 0; i < size; i++) {
                    int node = q.poll();
                    for (int friend : adj.get(node)) {
                        if (!vis[friend]) {
                            q.add(friend);
                            vis[friend] = true;
                        }
                    }
                }
            }
            currLevel++;
        }

        return ans;
    }
}