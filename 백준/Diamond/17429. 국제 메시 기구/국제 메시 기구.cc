#include <bits/stdc++.h>
#define endl "\n"
#define NM 500050
#define MAX 5555
#define BIAS 1048576
//#define MOD 1LL << 32
#define X first
#define Y second
#define INF 1e9
#define FOR(i) for(int _=0;_<(i);_++)
#define pii pair<int, int>
#define pll pair<ll, ll>
#define all(v) v.begin(), v.end()
#define fastio ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
//typedef long long ll;
typedef unsigned long long ll;
using namespace std;
const ll MOD = 1LL << 32;

int n, q;
int depth[NM], visited[NM], parent[NM], sz[NM], in[NM], out[NM], top[NM], cnt;
ll tree[NM * 4], lazy_mul[NM * 4], lazy_add[NM * 4];
vector<int> g[NM], v[NM];


// seg lazy
void prop(int node, int start, int end) {
    ll& mul = lazy_mul[node];
    ll& add = lazy_add[node];
    if (mul == 1 && add == 0) return;
    if (start != end) {
        lazy_mul[node << 1] *= mul;
        lazy_mul[node << 1] %= MOD;
        lazy_mul[node << 1 | 1] *= mul;
        lazy_mul[node << 1 | 1] %= MOD;
        lazy_add[node << 1] = mul * lazy_add[node << 1] + add;
        lazy_add[node << 1] %= MOD;
        lazy_add[node << 1 | 1] = mul * lazy_add[node << 1 | 1] + add;
        lazy_add[node << 1 | 1] %= MOD;
    }
    tree[node] = mul * tree[node] + (end - start + 1) * add;
    tree[node] %= MOD;
    mul = 1;
    add = 0;
}

void update(int node, int start, int end, int left, int right, ll mul, ll add) {
    prop(node, start, end);
    if (right < start || end < left) return;
    if (left <= start && end <= right) {
        lazy_mul[node] *= mul;
        lazy_mul[node] %= MOD;
        lazy_add[node] *= mul;
        lazy_add[node] %= MOD;
        lazy_add[node] += add;
        lazy_add[node] %= MOD;
        prop(node, start, end);
        return;
    }
    int mid = start + end >> 1;
    update(node << 1, start, mid, left, right, mul, add);
    update(node << 1 | 1, mid + 1, end, left, right, mul, add);
    tree[node] = (tree[node << 1] + tree[node << 1 | 1]) % MOD;
}

ll get(int node, int start, int end, int left, int right) {
    prop(node, start, end);
    if (right < start || end < left) return 0;
    if (left <= start && end <= right) return tree[node] % MOD;
    int mid = start + end >> 1;
    return (get(node << 1, start, mid, left, right) + get(node << 1|1, mid + 1, end, left, right)) % MOD;
}


// hld
void dfs(int cur) {
    visited[cur] = 1;
    for (int i = 0; i < g[cur].size(); i++) {
        if (visited[g[cur][i]]) continue;
        v[cur].push_back(g[cur][i]);
        dfs(g[cur][i]);
    }
}

void dfs2(int cur) {
    sz[cur] = 1;
    for (int i = 0; i < v[cur].size(); i++) {
        parent[v[cur][i]] = cur;
        depth[v[cur][i]] = depth[cur] + 1;
        dfs2(v[cur][i]);
        sz[cur] += sz[v[cur][i]];

        if (sz[v[cur][i]] > sz[v[cur][0]]) swap(v[cur][i], v[cur][0]);
    }
}

void dfs3(int cur) {
    in[cur] = ++cnt;
    for (int i = 0; i < v[cur].size(); i++) {
        top[v[cur][i]] = i == 0 ? top[cur] : v[cur][i];
        dfs3(v[cur][i]);
    }
    out[cur] = cnt;
}

void upd(int a, int b, ll mul, ll add) { // update chain
    while (top[a] != top[b]) {
        if (depth[top[a]] < depth[top[b]]) swap(a, b);
        update(1, 1, n, in[top[a]], in[a], mul, add);
        a = parent[top[a]];
    }
    if (depth[a] > depth[b]) swap(a, b);
    update(1, 1, n, in[a], in[b], mul, add);
}

ll query(int a, int b) {
    ll ret = 0;
    while (top[a] != top[b]) {
        if (depth[top[a]] < depth[top[b]]) swap(a, b);
        ret += get(1, 1, n, in[top[a]], in[a]);
        ret %= MOD;
        a = parent[top[a]];
    }
    if (depth[a] > depth[b])swap(a, b);
    ret += get(1, 1, n, in[a], in[b]);
    return ret % MOD;
}


void input() {
    cin >> n >> q;
    for (int i = 0; i < n - 1; i++) {
        int a, b;
        cin >> a >> b;
        g[a].push_back(b);
        g[b].push_back(a);
    }
}
void pro() {

    dfs(1);
    dfs2(1);
    dfs3(1);
    while (q--) {
        int oper;
        ll x, y, z;
        cin >> oper;
        if (oper == 1) {// 1 X V 금고 X의 서브트리에 있는 모든 금고에 V원을 더합니다. 
            cin >> x >> y;
            update(1, 1, n, in[x], out[x], 1, y);
        }else if (oper == 2) { // 2 X Y V 금고 X부터 금고 Y까지의 경로에 있는 모든 금고에 V원을 더합니다.
            cin >> x >> y >> z;
            upd(x, y, 1, z);
        }else if (oper == 3){ // 3 X V 금고 X의 서브트리에 있는 모든 금고의 돈을 V배 합니다.
            cin >> x >> y;
            update(1, 1, n, in[x], out[x], y, 0);
        }else if (oper == 4) { // 4 X Y V 금고 X부터 금고 Y까지의 경로에 있는 모든 금고의 돈을 V배 합니다. 
            cin >> x >> y >> z;
            upd(x, y, z, 0);
        }else if (oper == 5) { // 5 X 금고 X의 서브트리에 있는 모든 금고의 돈을 합한 값을 출력합니다.
            cin >> x;
            cout << get(1, 1, n, in[x], out[x]) << endl;
        }else { // 6 X Y 금고 X부터 금고 Y까지의 경로에 있는 모든 금고의 돈을 합한 값을 출력합니다. 
            cin >> x >> y;
            cout << query(x, y) << endl;
        }
    }
}
int main() {
    fastio;
    input();
    pro();
    return 0;
}