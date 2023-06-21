
#include<iostream>
 
#define endl "\n"
#define MAX 1001
using namespace std;
 
int N;
int Arr[MAX];
int DP[MAX];
 
void Input()
{
    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        cin >> Arr[i];
    }
}
 
void Solution()
{
    int Max = 0;
    for (int i = 1; i <= N; i++)
    {
        DP[i] = Arr[i];
        for (int j = 1; j < i; j++)
        {
            if (Arr[j] < Arr[i] && DP[i] < DP[j] + Arr[i])
            {
                DP[i] = DP[j] + Arr[i];
            }
        }
        if (Max < DP[i]) Max = DP[i];
    }
    cout << Max << endl;
}
 
void Solve()
{
    Input();
    Solution();
}
 
int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    //freopen("Input.txt", "r", stdin);
    Solve();
 
    return 0;
}


