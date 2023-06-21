
//그리디

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int i, n, k, m = 0;
	int a[11]; 

	scanf("%d%d", &n, &k);

	for (i = 0; i < n; i++)
	{
		scanf("%d", &a[i]);
	}

	for (i = n - 1; i >= 0; i--) 
	{
		m += k / a[i];
		k %= a[i];
	}

	printf("%d", m);
}