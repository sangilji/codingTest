#include<iostream>
using namespace std;

int N = 0, num = 0;
long count_0 = 0, count_1 = 0;

int main()
{   
    cin.tie(0)->sync_with_stdio(0);
    cin >> N;

    for (int i = 0; i < N; i++){
		cin >> num;
        if(num == 0)
            count_0 = count_0 + 1;
        else if(num == 1)
            count_1 = count_1 + 1;
    }

    cout << count_0 * count_1 * 2 + count_0 * (N - count_0 - count_1) + ((count_0 * (count_0 - 1)) / 2) << endl;
    
    return 0;
}