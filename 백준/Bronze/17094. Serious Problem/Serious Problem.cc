#include <iostream>
using namespace std;
string str;
int n;
int cnt1, cnt2;
 
int main(void) {
		cin >> n;
	cin >> str;
	for (int i = 0; i < n; i++) {
		if (str[i] == '2')
			cnt1++;
		else if (str[i] == 'e')
			cnt2++;
	}
	if (cnt1 == cnt2)
		cout << "yee";
	else if (cnt1 > cnt2)
		cout << '2';
	else
		cout << 'e';
 
		return 0;
}