#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0)
using namespace std;

#define X first
#define Y second
typedef pair<int, int> pii;
const int INF = int(1e9);

struct MinSegTree {
	int tree[1 << 18]; //arr[0, n-1] -> tree[sz, sz + n - 1]
	int sz = 1 << 17;
	void construct() {
		for (int i = sz - 1; i > 0; i--) {
			tree[i] = min(tree[i << 1], tree[i << 1 | 1]);
		}
	}
	//i : 1-indexed
	void update(int i, int val) {
		--i |= sz; tree[i] = val;
		while (i >>= 1) {
			tree[i] = min(tree[i << 1], tree[i << 1 | 1]);
		}
	}
	//[l, r] : 1-indexed
	int query(int l, int r) {
		--l |= sz, --r |= sz;
		int ret = INF;
		while (l <= r) {
			if (l & 1) ret = min(ret, tree[l++]);
			if (~r & 1) ret = min(ret, tree[r--]);
			l >>= 1, r >>= 1;
		}
		return ret;
	}
};

struct MaxSegTree {
	int tree[1 << 18]; //arr[0, n-1] -> tree[sz, sz + n - 1]
	int sz = 1 << 17;
	void construct() {
		for (int i = sz - 1; i > 0; i--) {
			tree[i] = max(tree[i << 1], tree[i << 1 | 1]);
		}
	}
	//i : 1-indexed
	void update(int i, int val) {
		--i |= sz; tree[i] = val;
		while (i >>= 1) {
			tree[i] = max(tree[i << 1], tree[i << 1 | 1]);
		}
	}
	//[l, r] : 1-indexed
	int query(int l, int r) {
		--l |= sz, --r |= sz;
		int ret = -INF;
		while (l <= r) {
			if (l & 1) ret = max(ret, tree[l++]);
			if (~r & 1) ret = max(ret, tree[r--]);
			l >>= 1, r >>= 1;
		}
		return ret;
	}
};

struct HLD {
	int n, cost[100001];
	int sz[100001], dep[100001], par[100001];
	int top[100001], in[100001], out[100001];
	vector<pii> inp[100001];
	vector<int> adj[100001];

	bool visited[100001];
	void dfs(int cur = 1) {
		visited[cur] = true;
		for (auto [ncost, nxt] : inp[cur]) {
			if (visited[nxt]) continue;
			adj[cur].push_back(nxt);
			cost[nxt] = ncost;
			dfs(nxt);
		}
	}

	void dfs1(int cur = 1) {
		sz[cur] = 1;
		for (auto& nxt : adj[cur]) {
			dep[nxt] = dep[cur] + 1; par[nxt] = cur;
			dfs1(nxt); sz[cur] += sz[nxt];
			if (sz[nxt] > sz[adj[cur][0]]) swap(nxt, adj[cur][0]);
		}
	}

	int temp;
	void dfs2(int cur = 1) {
		in[cur] = ++temp;
		for (auto nxt : adj[cur]) {
			top[nxt] = (nxt == adj[cur][0] ? top[cur] : nxt);
			dfs2(nxt);
		}
		out[cur] = temp;
	}

	MinSegTree mn;
	MaxSegTree mx;
	void precalc() {
		cin >> n;
		for (int i = 1 << 17; i < 1 << 18; i++) {
			mn.tree[i] = INF;
			mx.tree[i] = -INF;
		}
		for (int i = 0; i < n - 1; i++) {
			int a, b, c; cin >> a >> b >> c;
			inp[a].push_back({ c, b });
			inp[b].push_back({ c, a });
		}
		top[1] = 1;
		dfs(), dfs1(), dfs2();
		for (int i = 1; i <= n; i++) {
			mn.tree[mn.sz - 1 + in[i]] = cost[i];
			mx.tree[mx.sz - 1 + in[i]] = cost[i];
		}
		mn.construct();
		mx.construct();
	}
} HLD;

pii query(int a, int b) {
	int mn = INF, mx = -INF;
	while (HLD.top[a] != HLD.top[b]) {
		if (HLD.dep[HLD.top[a]] < HLD.dep[HLD.top[b]]) swap(a, b);
		int st = HLD.top[a];
		mn = min(mn, HLD.mn.query(HLD.in[st], HLD.in[a]));
		mx = max(mx, HLD.mx.query(HLD.in[st], HLD.in[a]));
		a = HLD.par[st];
	}
	if (a == b) return { mn, mx };
	if (HLD.dep[a] > HLD.dep[b]) swap(a, b);
	int nxt = -1;
	for (auto i : HLD.adj[a]) {
		if (HLD.top[a] == HLD.top[i]) nxt = i;
	}
	mn = min(mn, HLD.mn.query(HLD.in[nxt], HLD.in[b]));
	mx = max(mx, HLD.mx.query(HLD.in[nxt], HLD.in[b]));
	return { mn, mx };
}

int main() {
	fastio;
	HLD.precalc();
	int q; cin >> q;
	while (q--) {
		int a, b; cin >> a >> b;
		pii ans = query(a, b);
		cout << ans.X << ' ' << ans.Y << '\n';
	}
}