import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 여벌 체육복을 가진 학생이 도난당했을 경우를 처리하기 위해 배열을 복사
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복을 가진 학생 중 도난당한 학생을 먼저 제외
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    reserve[i] = -1; // 여벌 체육복을 가진 학생 표시
                    lost[j] = -1;   // 도난당한 학생 표시
                    break;
                }
            }
        }
        
        // 체육복 빌려주는 과정을 처리
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] != -1 && lost[j] != -1 && 
                   (reserve[i] == lost[j] - 1 || reserve[i] == lost[j] + 1)) {
                    reserve[i] = -1; // 여벌 체육복을 빌려줌
                    lost[j] = -1;   // 도난당한 학생 해결
                    break;
                }
            }
        }
        
        // 체육복을 가진 학생 수 계산
        int answer = n - (int) Arrays.stream(lost).filter(x -> x != -1).count();
        return answer;
    }
}
