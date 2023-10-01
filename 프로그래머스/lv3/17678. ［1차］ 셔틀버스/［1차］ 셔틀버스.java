import java.util.*;

class Solution {
    static int[] busArrivalTimes;
    static List<Integer>[] waitingCrewList;
    
    public String solution(int n, int t, int m, String[] timetable) {
        busArrivalTimes = new int[n];
        waitingCrewList = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            busArrivalTimes[i] = 540 + i * t;
            waitingCrewList[i] = new ArrayList<>();
        }
        
        Arrays.sort(timetable);
        
        for (String timeStr : timetable) {
            int crewArrivalTime = strToMinutes(timeStr);
            findBusAndBoard(crewArrivalTime, n, m);
        }
        
        int answer = getAnswer(n, m);
        return minutesToStr(answer);
    }
    
    static int strToMinutes(String timeStr) {
        StringTokenizer st = new StringTokenizer(timeStr, ":");
        int hours = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        return hours * 60 + minutes;
    }
    
    static String minutesToStr(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }
    
    static void findBusAndBoard(int crewArrivalTime, int n, int m) {
        if (busArrivalTimes[n - 1] < crewArrivalTime)
            return;
        
        for (int i = 0; i < n; i++) {
            if (busArrivalTimes[i] >= crewArrivalTime && waitingCrewList[i].size() < m) {
                waitingCrewList[i].add(crewArrivalTime);
                break;
            }
        }
    }
    
    static int getAnswer(int n, int m) {
        if (waitingCrewList[n - 1].size() < m)
            return busArrivalTimes[n - 1];
        
        return waitingCrewList[n - 1].get(m - 1) - 1;
    }
}
