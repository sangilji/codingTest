#include <bits/stdc++.h>
#define endl "\n"
#define fastio ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
//typedef long long ll;
typedef unsigned long long ll;
using namespace std;
vector<int> arr;
vector<int> tree;
int t;

void init(int node, int start, int end) {
    if (start == end) {
        tree[node] = start;
        return;
    }
    int mid = (start + end) >> 1;
    init(node << 1, start, mid);
    init(node << 1 | 1, mid + 1, end);
    if (arr[tree[node << 1]] <= arr[tree[node << 1 | 1]]) {
        tree[node] = tree[node << 1];
    } else {
        tree[node] = tree[node << 1 | 1];
    }
}

int get(int node, int start, int end, int left, int right) {
    if (right < start || end < left) {
        return 0;
    }
    if (left <= start && end <= right) {
        return tree[node];
    }
    int mid = (start + end) >> 1;
    int a = get(node << 1, start, mid, left, right);
    int b = get(node << 1 | 1, mid + 1, end, left, right);
    if (a == 0) {
        return b;
    }
    if (b == 0) {
        return a;
    }
    if (arr[a] <= arr[b]) {
        return a;
    }
    return b;
}

ll query(int start, int end) {
    int min = get(1, 1, t, start, end);
    ll result = 1LL*(end - start + 1) * arr[min];
    if (min + 1 <= end) {
        result = max(result, query(min + 1, end));
    }
    if (min - 1 >= start) {
        result = max(result, query(start, min - 1));
    }
    return result;  
}


int main() {
    fastio;
    cin >> t;    
    arr.resize(t+1);
    tree.resize((t+1)<<2);
    for(int i = 1 ; i<=t;i++){
        cin >> arr[i];
    }
    init(1,1,t);
    cout << query(1,t) << endl;
    return 0;
}