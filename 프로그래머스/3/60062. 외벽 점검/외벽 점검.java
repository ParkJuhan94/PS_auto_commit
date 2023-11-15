// package Programmers.Level_3.외벽점검;

class Solution {
    int[] weak, dist;
    int[][] weakCases;
    int n, answer;

    public int solution(int n, int[] weak, int[] dist) {
        weakCases = new int[weak.length][weak.length];
        this.weak = weak;
        this.dist = dist;
        this.answer = dist.length + 1;
        this.n = n;

        makeWeakCases();
        makeDistCases(0, new boolean[dist.length], new int[dist.length]);

        if (answer == dist.length + 1) {
            return -1;
        } else {
            return answer;
        }
    }

    void makeWeakCases() {
        int[] weakCase = this.weak.clone();
        weakCases[0] = weakCase.clone();

        for (int i = 1; i < weak.length; i++) {
            int firstWeak = weakCase[0];
            for (int j = 1; j < weak.length; j++) {
                weakCase[j - 1] = weakCase[j];
            }

            // 갱신되는 마지막 waek 위치는 처음 weak 위치에서 전체 길이를 더해준다
            weakCase[weak.length - 1] = firstWeak + n;
            weakCases[i] = weakCase.clone();
        }
    }

    void makeDistCases(int depth, boolean[] distVisit, int[] distCase) {
        if (depth == dist.length) {
            for (int[] weakCase : weakCases)
                check(distCase, weakCase);
        }

        // 순열
        for (int i = 0; i < dist.length; i++) {
            if (!distVisit[i])
            {
                distVisit[i] = true;
                distCase[depth] = dist[i];
                makeDistCases(depth + 1, distVisit, distCase);
                distCase[depth] = 0;
                distVisit[i] = false;
            }
        }
    }

    void check(int[] distCase, int[] weakCase) {
        int cur = 0;
        int next;
        int distIdx = 0;

        while (cur < weakCase.length && distIdx < distCase.length) {
            next = cur + 1;
            while (next < weakCase.length &&
                    weakCase[cur] + distCase[distIdx] >= weakCase[next]) {
                next++;
            }
            cur = next;
            distIdx++;
        }

        if (cur == weakCase.length && distIdx < answer)
            answer = distIdx;
    }
}
