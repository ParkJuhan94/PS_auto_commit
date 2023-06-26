#include <iostream>
using namespace std;

void hanoi(int n, int from, int to, int bypass) 
{
	if (n == 1) {
		printf("%d %d\n", from, to);
	}
	else {
		hanoi(n - 1, from, bypass, to);
		printf("%d %d\n", from, to);
		hanoi(n - 1, bypass, to, from);
	}
}

int main() {
	int N;
	cin >> N;

	printf("%d\n", (1 << N) - 1);// N을 좌로 1비트 이동 -> (2^N - 1)을 출력
	hanoi(N, 1, 3, 2);

	return 0;
}