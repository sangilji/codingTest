#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(0), cin.tie(0)
using namespace std;
using ll = long long;
using pii = pair<int, int>;
#define all(v) v.begin(), v.end()

int dx[8] = {1, 0, -1, 0, 1, -1, -1, 1};
int dy[8] = {0, 1, 0, -1, 1, 1, -1, -1};

const int N = 1<<11;
vector<int> arr[2001];
ll tree[N<<1];
int n, m;

void input() {
    cin >> n >> m;
    for(int i = 0; i < m; ++i) {
        int a, b; cin >> a >> b;
        arr[a].push_back(b);
    }
}

ll query(int l, int r, int i = 1, int s = 0, int e = N-1) {
    if(l > e || r < s) return 0;
    if(l <= s && e <= r) return tree[i];
    int m = (s + e) >> 1;
    return query(l, r, i<<1, s, m) + query(l, r, i<<1|1, m+1, e);
}

void update(int l, int r, int i = 1, int s = 0, int e = N-1) {
    if(l > e || r < s) return ;
    if(l <= s && e <= r) {
        tree[i]++;
        return ;
    }
    int m = (s + e) >> 1;
    update(l, r, i<<1, s, m);
    update(l, r, i<<1|1, m+1, e);
    tree[i] = tree[i<<1] + tree[i<<1|1];
}

int main() {
    fastio;
    input();

    ll ans = 0;
    for(int i = 1; i <= n; ++i) {
        for(auto& v : arr[i]) ans += query(v+1, n);
        for(auto& v : arr[i]) update(v, v);
    }
    cout << ans;
}