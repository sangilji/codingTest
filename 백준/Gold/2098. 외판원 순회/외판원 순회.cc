#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int N;
int arr[16][16];
int dp[16][1<<16];
void input() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
		}
	}
	memset(dp, -1, sizeof(dp));
}


int dfs(int n, int bit) {
	if (bit == (1 << N) - 1) {
		if (!arr[n][0]) {
			return 1e9;
		}
		return arr[n][0];
	}
	int &ret = dp[n][bit];
	if (ret != -1) 
		return ret;
	ret = 1e9;
	for (int i = 0; i < N; i++) {
		if (arr[n][i] != 0 && (bit & (1<<i)) != (1<<i)) {
			ret = min(ret, arr[n][i]+dfs(i, bit|1<<i));
		}
	}
	return ret;

}

void solve() {
	input();
	cout<<dfs(0,1);

}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	solve();

	return 0;
}