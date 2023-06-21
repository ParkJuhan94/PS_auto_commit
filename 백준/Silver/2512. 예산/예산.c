#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int N;              //지방의 수
long M;             //총 예산
long* required;
long sum = 0;
int i;

bool isPossible(long quantity) {
    sum = 0;

    for (i = 0; i < N; i++) {
        if (required[i] < quantity) {
            sum += required[i];
        }
        else {
            sum += quantity;
        }
        if (sum > M) {
            return false;
        }
    }
    return true;    
}

// data : 탐색할 오름차순으로 정렬된 정수 배열
// n : 정수 배열의 크기
// key : 찾고자하는 값
long solve(long max) {
    int low, high;
    int mid;
    int res = 0;

    low = 0;
    high = max;
    while (low <= high) {
        mid = (low + high) / 2;

        if (isPossible(mid)) {
            res = mid;
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }        
    }
    return res;
}


int main() {
    long max = 0;

    scanf("%d", &N);
    required = malloc(sizeof(long) * N);
    for (i = 0; i < N; ++i) {
        scanf("%d", &required[i]);

        if (max < required[i]) {
            max = required[i];
        }
    }
    scanf("%d", &M);
    
    printf("%d\n", solve(max));
}
