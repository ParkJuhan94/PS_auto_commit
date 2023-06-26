import java.util.Scanner;

public class Main {
    static int N; // 수열의 길이
    static int[] numbers; // 수열
    static int[] operators; // 연산자 배열
    static int maxResult = Integer.MIN_VALUE; // 최댓값
    static int minResult = Integer.MAX_VALUE; // 최솟값

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        numbers = new int[N];
        operators = new int[4]; // 연산자 개수는 +, -, *, / 4가지

        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = scanner.nextInt();
        }

        // 재귀 함수 호출
        calculate(numbers[0], 1);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    static void calculate(int num, int idx) {
        // 모든 숫자를 사용한 경우, 최댓값과 최솟값 업데이트
        if (idx == N) {
            maxResult = Math.max(maxResult, num);
            minResult = Math.min(minResult, num);
            return;
        }

        // 각 연산자에 대해 재귀 호출
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0: // 덧셈
                        calculate(num + numbers[idx], idx + 1);
                        break;
                    case 1: // 뺄셈
                        calculate(num - numbers[idx], idx + 1);
                        break;
                    case 2: // 곱셈
                        calculate(num * numbers[idx], idx + 1);
                        break;
                    case 3: // 나눗셈
                        calculate(num / numbers[idx], idx + 1);
                        break;
                }

                operators[i]++; // 재귀 호출 이후 연산자 개수 복구
            }
        }
    }
}
