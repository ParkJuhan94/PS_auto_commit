#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
    int i,j;
    int n, m;    
    int num = 0;
    int cnt = 0;
    int sum = 0;
    int min = 20000;

    scanf("%d %d", &m, &n);

    for (i = m; i <= n; i++) {
        num = 0;
        if (i > 1) {
            for (j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    num++;
                }
            }
            if (num == 1) {
                sum += i;
                if (i < min) {
                    min = i;
                }
                cnt++;
            }
        }
    }

    if (cnt == 0) {
        printf("-1\n");
    }else{
        printf("%d\n", sum);
        printf("%d\n", min);
    }    
}