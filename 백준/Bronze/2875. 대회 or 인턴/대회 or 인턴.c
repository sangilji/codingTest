#include<stdio.h>
int main() {

	int n, m, k;
	int count;
	int result = 0;
	int woman, man;
	scanf("%d %d %d", &n, &m, &k);
	for (int i = 0;i <= k;i++) {
		count = 0;
		woman = n;man = m;
		woman = woman - i;
		man = man-(k - i);
		while (woman>=2&&man>=1) {
			woman = woman - 2;
			man--;
			count++;
			
		}
		if (result < count) {
			result = count;
		}
	}
	
	printf("%d", result);
}