#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>  // Add this line for INT_MAX

using namespace std;

int n;
vector<int> dp;
int min_val = INT_MAX;

bool recur(int cur) {
    if (cur <= 0) {
        return true;
    }
    if (cur < 10) {
        return false;
    }
    if (dp[cur] != -1) {
        return dp[cur] == 1;
    }
    int start = 1;
    while (start <= cur) {
        start *= 10;
    }
    int count = 0;
    while (start > 1) {
        int a = cur % start;
        start /= 10;
        int tmp = 1;
        while (tmp <= a) {
            if (!recur(cur - (a / tmp))) {
                count++;
                if (cur == n) {
                    min_val = min(a / tmp, min_val);
                }
            }
            tmp *= 10;
        }
    }
    if (count > 0) {
        dp[cur] = 1;
    } else {
        dp[cur] = 0;
    }
    return count > 0;
}

int main() {
    cin >> n;
    dp.assign(n + 1, -1);
    if (recur(n)) {
        cout << min_val << endl;
    } else {
        cout << -1 << endl;
    }
    return 0;
}