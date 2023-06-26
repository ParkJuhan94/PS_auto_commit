
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int tmp[2000002];

void merge(int arr[], int left, int right) {

    int L, R, k, a;
    int mid = (left + right) / 2;
    L = left;
    R = mid + 1;
    k = left;

    while (L <= mid && R <= right)
        tmp[k++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];

    if (L > mid)
        for (a = R; a <= right; a++)
            tmp[k++] = arr[a];
    else
        for (a = L; a <= mid; a++)
            tmp[k++] = arr[a];

    for (a = left; a <= right; a++)
        arr[a] = tmp[a];

}

void mergeSort(int arr[], int left, int right) {

    if (left == right) return;
    int mid;
    mid = (left + right) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, right);

}

int main() {
    int n, m, i;
    int len;

    scanf("%d %d", &n, &m);
    len = n + m;
    int* arr = malloc(sizeof(int) * (len));

    for (i = 0; i < n; i++) {
        scanf("%d", arr + i);
    }

    for (i = n; i < n + m; i++) {
        scanf("%d", arr + i);
    }

    //=============================================
    mergeSort(arr, 0, len - 1);
    for (i = 0; i < len; i++) {
        printf("%d ", *(arr + i));
    }

    return 0;
}