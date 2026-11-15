
class Solution {
public:
    
    vector<string> watchedVideosByFriends(vector<vector<string>>& watchedVideos,
                                          vector<vector<int>>& friends, int id,
                                          int level) {
        vector<int> adj[friends.size()];
        for (int i = 0; i < friends.size(); i++) {
            for (auto it : friends[i]) {
                adj[i].push_back(it);
            }
        }
        queue<int> q;
        vector<string> ans;
        vector<bool> visited(friends.size(), false);
        q.push(id);
        visited[id] = true;
        int currLevel = 0;
        while (!q.empty()) {
            int size = q.size();
            if (currLevel == level) {
                unordered_map<string, int> mpp;
                for (int i = 0; i < size; i++) {
                    int node = q.front();
                    q.pop();
                    auto vid = watchedVideos[node];
                    for (auto it : vid) {
                        mpp[it]++;
                    }
                }

                vector<pair<int, string>> temp;
                for (auto it : mpp) {
                    temp.push_back({it.second, it.first});
                }

                sort(temp.begin(), temp.end());

                for (auto it : temp) {
                    ans.push_back(it.second);
                }

                break;
            } else {
                for (int i = 0; i < size; i++) {
                    int node = q.front();
                    q.pop();
                    for (auto it : adj[node]) {
                        if (visited[it] != true) {
                            q.push(it);
                            visited[it] = true;
                        }
                    }
                }
            }
            currLevel++;
        }
        return ans;
    }
};
