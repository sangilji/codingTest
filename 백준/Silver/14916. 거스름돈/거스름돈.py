import sys

input = sys.stdin.readline


def recur(cur):
    if cur < 0:
        return 123123123
    if cur == 0:
        return 0
    if dp[cur] != -1:
        return dp[cur]
    dp[cur] = min(recur(cur - 2), recur(cur - 5)) + 1
    return dp[cur]


n = int(input())
dp = [123123123] * 100001
dp[0] = 0
dp[2] = 1
dp[4] = 2
dp[5] = 1
for i in range(6, n + 1):
    dp[i] = min(dp[i - 2], dp[i - 5]) + 1

if dp[n] >= 123123123:
    print(-1)
else:
    print(dp[n])