#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;
const int MAX = 3000;

int arr[MAX];
bool visited[MAX];

int main(void)
{
        int N;
        while (scanf("%d", &N) != EOF)
        {
                 memset(visited, false, sizeof(visited));
                 for (int i = 0; i < N; i++)
                         cin >> arr[i];
                 bool flag = true;
            
                 for (int i = 0; i < N - 1; i++)
                 {
                         int diff = abs(arr[i] - arr[i + 1]);
                         if (visited[diff] || !diff || diff >= N) {
                                 flag = false;
                                 break;
                         }

                         visited[diff] = true;
                 }

                 if (flag)
                         cout << "Jolly\n";
                 else
                         cout << "Not jolly\n";
        }
        return 0;
}