//package TEST.P2108;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int[] count = new int[8001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            count[number + 4000]++;
            numbers[i] = number;
        }

        bw.write(average(numbers) + "\n");
        bw.write(middle(numbers) + "\n");
        bw.write(frequency() + "\n");
        bw.write(range(numbers) + "\n");

        bw.flush();
        bw.close();
    }

    // 산술평균 : N개의 수들의 합을 N으로 나눈 값
    private static int average(int[] numbers) {
        int sum = 0;

        for(int value : numbers) {
            sum += value;
        }

        double round = (double) Math.round((double) sum / (double) numbers.length);

        return (int) round;
    }

    //중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
    private static int middle(int[] numbers) {
        Arrays.sort(numbers);

        // 짝 홀 둘 다 가능
        return numbers[numbers.length / 2];
    }

    //최빈값 : N개의 수들 중 가장 많이 나타나는 값
    private static int frequency() {
        List<Integer> temp = new ArrayList<>();
        int max = count[0];
        temp.add(0 - 4000);

        for (int i = 1; i < count.length; i++) {
            if(count[i] == max) {
                temp.add(i - 4000);
            } else if(count[i] > max) {
                max = count[i];
                temp.clear();
                temp.add(i - 4000);
            }
        }

        if(temp.size() > 1) {
            Collections.sort(temp);
            return temp.get(1);
        }else {
            return temp.get(0);
        }
    }

    //범위 : N개의 수들 중 최댓값과 최솟값의 차이
    private static int range(int[] numbers) {
        return numbers[numbers.length - 1] - numbers[0];
    }
}