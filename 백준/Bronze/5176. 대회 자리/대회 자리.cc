#include <iostream>
#include <cstring>
using namespace std;
int k,p,m,n;
int main() {
    cin >> k;
    while (k--)
    {
        cin >> p >> m;
        int *a = new int[m];
        for (int i = 0; i < m; i++)
            a[i] = 0;
        int ans = 0;
        for (int i = 1; i <= p; i++)
        {
            cin >> n;
            a[n-1]++;
        }
        for (int i = 0; i < m; i++)
        {
            if (a[i] > 1)
                ans += a[i] - 1;
        }
        cout << ans << '\n';
    }
}