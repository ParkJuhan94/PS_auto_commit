package Programmers.Level_3.자물쇠와열쇠;

class Solution {
    static int l, k;

    public boolean solution(int[][] key, int[][] lock) {
        l = lock.length;
        k = key.length;

        int rotationCount = 4;  // 열쇠를 회전한 횟수
        int[][] currentKey = copyKey(key); // 현재 열쇠

        while (rotationCount-- > 0) {

            int[][] extendedKey = extendKeyToLock(currentKey);

            boolean isMatch = matchKeyToLock(extendedKey, lock); // 열쇠와 자물쇠가 일치하는지 확인
            if (isMatch) return true;



            currentKey = rotateKey(currentKey); // 열쇠를 90도 시계방향으로 회전
            rotationCount++;
        }

        return false;
    }

    static boolean matchKeyToLock(int[][] key, int[][] lock) {

        for (int i = 0; i < k + l - 1; i++) {
            for (int j = 0; j < k + l - 1; j++) {
                boolean isOverlap = true; // 열쇠와 자물쇠가 겹치는지

                for (int r = 0; r < l; r++) {
                    for (int c = 0; c < l; c++) {
                        if (lock[r][c] == key[i + r][j + c]) {
                            isOverlap = false; // 겹치면 false
                            break;
                        }
                    }
                    if(!isOverlap){
                        break;
                    }
                }

                if (isOverlap) {
                    return true; // 겹치지 않는 경우 true 반환
                }
            }
        }


        return false;
    }

    static int[][] extendKeyToLock(int[][] src) {
        // 확장된 열쇠 크기 (M+2*(N-1)) x (M+2*(N-1))
        // key 를 가운데 fix 후 확장, lock 이 확장된 key 를 돌아다니도록
        int[][] extendedKey = new int[k + 2 * (l - 1)][k + 2 * (l - 1)];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                extendedKey[i + l - 1][j + l - 1] = src[i][j]; // 중앙에 열쇠 복사
            }
        }

        return extendedKey;
    }

    static int[][] rotateKey(int[][] src) {
        int[][] rotatedKey = new int[k][k];
        int col = k - 1;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rotatedKey[j][col] = src[i][j];
            }

            col--;
        }

        return rotatedKey;
    }

    static int[][] copyKey(int[][] src) {
        int[][] copy = new int[k][k];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                copy[i][j] = src[i][j]; // 열쇠 복사
            }
        }

        return copy;
    }
}
