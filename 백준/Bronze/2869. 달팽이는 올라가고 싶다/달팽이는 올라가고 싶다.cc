#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main() {
	int a, b, v, day;


	scanf("%d %d %d", &a, &b, &v);

	if ((v-a) % (a-b) == 0) 
	{
		day = (v - a) / (a - b) + 1;
	}
	else {
		day = (v - a) / (a - b) + 2;
	}
	
	printf("%d", day);
}