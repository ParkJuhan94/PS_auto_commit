import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        // 1. 진입 지점으로 오름차순 정렬 2. 진출 지점으로 내림차순 정렬
        // 진입 지점이 같은 경우를 생각해보자.
        Arrays.sort(routes, (o1, o2) -> {
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else{
                return o2[1] - o1[1];
            }
        });

        int end = routes[0][1];    // 현재까지 체크한 루트의 진출 지점
        answer = 1;

        // 카메라가 다음 루트에 포함되면서 && 제일 뒤로 배치되도록 한다
        for(int i = 1; i < routes.length; i++)
        {
            int[] route = routes[i];

            // 포함된다면 : 제일 뒤로 배치
            if(end >= route[1]){
                end = route[1];
            }
            // 포함 안되면 : answer++ 하고 제일 뒤로 배치
            else if(end < route[0]){
                end = route[1];
                answer++;
            }
        }

        return answer;
    }
}