#include <iostream>
#include <vector>
#include <queue>
#include <sstream>

using namespace std;

const int MOD = 1e9 + 9;
const int INF = 2e9;

int n, m, k, x, y;
vector<vector<int>> arr;
vector<int> visit;
vector<int> counts;
vector<vector<int>> nodes;

vector<int> dx = {0, 0, 1, -1};
vector<int> dy = {1, -1, 0, 0};
stringstream sb;

int bfs(int current) {
    queue<int> q;
    q.push(current);
    vector<bool> visited(n + 1, false);
    visited[current] = true;
    int count = 0;
    
    while (!q.empty()) {
        int tmp = q.front();
        q.pop();
        
        for (int next : nodes[tmp]) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            count++;
            q.push(next);
        }
    }
    
    return count;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;
    counts.resize(n + 1);
    nodes.resize(n + 1);

    for (int i = 0; i < n + 1; i++) {
        nodes[i] = vector<int>();
    }

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        nodes[b].push_back(a);
    }

    int maxCount = 0;
    for (int i = 1; i < n + 1; i++) {
        counts[i] = bfs(i);
        maxCount = max(counts[i], maxCount);
    }

    for (int i = 1; i < n + 1; i++) {
        if (counts[i] == maxCount) {
            sb << i << " ";
        }
    }

    cout << sb.str() << endl;

    return 0;
}