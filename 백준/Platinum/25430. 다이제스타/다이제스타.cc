#include<bits/stdc++.h>
#define M 1e18
using namespace std;
 
map <int, vector<pair<int, int>>> E;
vector<long long> D(50001, M), T(50001, M);
int n, m, s, e;
 
int main()
{
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n >> m;
    for (int u, v, c; m--; E[c].emplace_back(u, v)) cin >> u >> v >> c;
    cin >> s >> e; D[s] = 0;
    for (auto& [c, V] : E)
    {
        for (auto& [u, v] : V)
            T[u] = min(T[u], D[v] + c), T[v] = min(T[v], D[u] + c);
        for (auto& [u, v] : V)
        {
            D[u] = min(D[u], T[u]), T[u] = M;
            D[v] = min(D[v], T[v]), T[v] = M;
        }
    }
    D[e] == M ? cout << "DIGESTA" : cout << D[e];
}