#include<stdio.h>
#include<string.h>

int main() {
	char x[100001];
	int n[10] = {0};
	int a,sum=0;

	scanf("%s", x);
	for (int i = 0;i < strlen(x);i++) {
		a = x[i] - '0';
		n[a]++;
	}
	if (n[0] == 0) {
		printf("-1");
		return 0;
		
	}
	for (int i = 0;i < 10;i++) {
		sum =sum+ (n[i] *i);
	}
	if (sum % 3 != 0) {
		printf("-1");
		return 0;

	}
	for (int i = 9;i >= 0;i--) {
		for (int j = 0;j < n[i];j++)
			printf("%d", i);
	}
}