
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
    int i, j;
    int n = 1;
    int num = 0;
    int cnt = 0;
    while (n) {
        cnt = 0;
        scanf("%d", &n);

        for (i = n + 1; i <= 2 * n; i++) {
            num = 0;
            if (i > 1) {
                for (j = 1; j * j <= i; j++) {
                    if (j == 1) {
                        if (i % j == 0) {
                            num++;
                        }
                    }
                    else {
                        if (i % j == 0) {
                            num++;
                            break;
                        }
                    }
                }
                if (num == 1) {
                    cnt++;
                }
            }
        }
        if (cnt != 0) {
            printf("%d\n", cnt);
        }
        
    }
}