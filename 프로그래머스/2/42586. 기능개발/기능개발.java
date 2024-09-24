import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] leftDays = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                leftDays[i] = (100 - progresses[i]) / speeds[i];
            } else {
                leftDays[i] = (100 - progresses[i]) / speeds[i] + 1;
            }
        }

        int sum = 1;
        int max = leftDays[0];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < leftDays.length; i++) {
            if (leftDays[i] <= max) {
                sum++;
            } else {
                list.add(sum);
                sum = 1;
                max = leftDays[i];
            }

            // 마지막 작업 그룹이 list에 안 들어갔다면
            if(i == leftDays.length - 1) {
                list.add(sum);
            }
        }

        for(Integer i : list) {
            System.out.println(i);
        }

        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}