#include<stdio.h>
int main() {

	int a[10];
	int n, k;
	int count = 0;
	int x;
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n;i++) {
		scanf("%d", &a[i]);
	}
	x = n - 1;
	while (k != 0) {
		
		if (a[x] > k) {
			x--;

		}
		else {
			count++;
			k -= a[x];

		}
	}
	printf("%d", count);
}