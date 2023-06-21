
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

/*
a는 첫 항이고, b는 두 번째 항이다.
처음에 둘 다 1로 시작하므로 마지막 역시 a와 b가 1이 된다면 한 주기가 완성된 것이다.
m으로 나눈 나머지에 대해서만 고려하면 되므로 a+b를 하고 항상 %m을 해준다.
*/
int main() {
    int P, N, M;
    scanf("%d", &P);

    int cnt, a, b;
    for (int i = 0; i < P; i++) {
        scanf("%d %d", &N, &M);
        cnt = 0;
        a = b = 1;

        while (1) {
            int tmp = (a + b) % M;
            a = b;
            b = tmp;
            cnt++;

            //주기를 찾으면 break
            if (a == 1 && b == 1) break;
        }
        printf("%d %d\n", N, cnt);
    }
    return 0;
}