#include<stdio.h>
#include<string.h>

int main() {
	long long int n, m;
	scanf("%lld %lld", &n, &m);
	if (n == 1) {
		printf("1");
	}
	else if (n == 2) {
		if (m >= 7)
			printf("4");
		else
			printf("%lld", (m + 1) / 2);
	}
	else if (n >= 3) {
		if (m < 7) {
			if (m == 1)
				printf("1");
			else if (m == 2)
				printf("2");
			else if (m == 3)
				printf("3");
			else if (m > 3)
				printf("4");
		}
		else {
			printf("%lld", m - 2);
		}
	}
}