//package Programmers.Level_2.양궁대회;

import java.util.ArrayList;
import java.util.Collections;

class Solution {

    static int[] answer = {-1};
    static int[] apeach;
    static int[] lion;
    static ArrayList<int[]> list = new ArrayList<>();
    static int max = -1; // 점수차의 최대값

    public int[] solution(int n, int[] info) {
        apeach = info;
        lion = new int[11];
        search(n, 0, 0);

        // 정답이 여러개면 정렬해서 하나만 출력
        // 낮은 점수부터 내림차순 정렬
        Collections.sort(list, (o1, o2) -> {
            for(int i = 10; i >= 0; i--)
                if(o1[i] != o2[i]) return o2[i] - o1[i];

            return 0;
        });

        if(!list.isEmpty()){
            answer = list.get(0);
        }

        return answer;
    }

    // 백트래킹 (dfs)
    void search(int n, int start, int depth){
        if(depth == n){
            // n개 쏘고나면 총점 계산
            int scoreApeach = 0;
            int scoreLion = 0;

            for(int i = 0; i <= 10; i++){
                if(apeach[i] != 0 || lion[i] != 0)  // 둘 중 한명이라도 맞춘 과녁이어야 점수 계산!
                    if(apeach[i] >= lion[i]) scoreApeach += (10 - i);
                    else scoreLion += (10 - i);
            }

            int plusLion = scoreLion - scoreApeach;

            if(plusLion > 0){           // 라이언이 이기면서
                if(plusLion > max){     // 점수차가 최대이면
                    max = plusLion;     // 점수차 갱신
                    list.clear();       // 정답 list 초기화
                    list.add(lion.clone()); // list.add(lion) 으로 넣으면 안돼!
                }
                else if (plusLion == max)
                {
                    list.add(lion.clone()); // list.add(lion) 으로 넣으면 안돼!
                }
            }

            return;
        }

        for(int i = start; i <= 10; i++){
            lion[i]++;
            search(n, i, depth + 1);
            lion[i]--;
        }
    }
}