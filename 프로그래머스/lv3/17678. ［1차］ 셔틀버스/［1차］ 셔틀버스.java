// package Programmers.Level_3.셔틀버스;

import java.util.*;

class Solution {
    static int n, m;
    static int[] busArrivalTimes;
    static List<Integer>[] crewInBusList;

    public String solution(int n, int t, int m, String[] timetable) {
        this.n = n;
        this.m = m;
        busArrivalTimes = new int[n];
        crewInBusList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            // 버스 도착 시간 계산 및 리스트 초기화
            busArrivalTimes[i] = 540 + i * t;
            crewInBusList[i] = new ArrayList<>();
        }

        // 크루 도착 시간을 정렬
        Arrays.sort(timetable);

        // 크루별로 버스를 찾아 탑승 처리
        for (String timeStr : timetable) {
            int crewArrivalTime = strToMinutes(timeStr); // 도착 시간을 분 단위로 변환
            findBusAndBoard(crewArrivalTime); // 크루가 어떤 버스를 타고 탑승할지 찾음
        }


        int answer = getAnswer();
        return minutesToStr(answer);
    }

    static int strToMinutes(String timeStr) {
        StringTokenizer st = new StringTokenizer(timeStr, ":");
        int hours = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());

        return hours * 60 + minutes;
    }

    static String minutesToStr(int minutes) {
        int hour = minutes / 60;
        int min = minutes % 60;

        return String.format("%02d:%02d", hour, min);
    }

    static void findBusAndBoard(int crewArrivalTime) {
        // 가장 늦은 버스보다 늦게 도착한 크루는 어떤 버스도 탈 수 없음
        if (busArrivalTimes[n - 1] < crewArrivalTime)
            return;

        // 버스 자리가 남아있고 크루 도착 시간이 버스 도착 시간과 같거나 작을 때 탑승 처리
        for (int i = 0; i < n; i++) {
            if (busArrivalTimes[i] >= crewArrivalTime && crewInBusList[i].size() < m) {
                crewInBusList[i].add(crewArrivalTime); // 크루 탑승 처리
                break;
            }
        }
    }

    static int getAnswer() {
        // 마지막 버스의 자리가 비어있다면 마지막 버스의 출발 시간을 반환
        if (crewInBusList[n - 1].size() < m)
            return busArrivalTimes[n - 1];

        // 마지막 버스가 다 찼다면 가장 늦게 탑승한 크루보다 1분 일찍 도착한 시간을 반환!
        return crewInBusList[n - 1].get(m - 1) - 1;
    }
}
