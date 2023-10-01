class Solution {
	static int n, m;
	
	public boolean solution(int[][] key, int[][] lock) {
		n = lock.length; // 자물쇠의 크기 (NxN)
		m = key.length;  // 열쇠의 크기 (MxM)
        
		int rotationCount = 0;  // 열쇠를 회전한 횟수
		int[][] currentKey = copyKey(key); // 현재 열쇠
		while (rotationCount < 4) {
			int[][] extendedKey = extendKeyToLock(currentKey); // 확장된 열쇠 크기 (M+2*(N-1))x(M+2*(N-1))
			boolean isMatch = matchKeyToLock(extendedKey, lock); // 열쇠와 자물쇠가 일치하는지 확인
			if (isMatch) {
				return true;
			}
			currentKey = rotateKey(currentKey); // 열쇠를 90도 시계방향으로 회전
			rotationCount++;
		}
		return false;
	}
	
	static boolean matchKeyToLock(int[][] key, int[][] lock) {
		for (int i = 0; i < m + n - 1; i++) {
			for (int j = 0; j < m + n - 1; j++) {
				boolean isOverlap = true; // 열쇠와 자물쇠가 겹치는지 여부
				out:
				for (int y = 0; y < n; y++) {
					for (int x = 0; x < n; x++) {
						if (lock[y][x] == key[i + y][j + x]) {
							isOverlap = false; // 겹치면 false 설정
							break out;
						}
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
		int[][] extendedKey = new int[m + 2 * (n - 1)][m + 2 * (n - 1)];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				extendedKey[i + n - 1][j + n - 1] = src[i][j]; // 중앙에 열쇠 복사
			}
		}
		return extendedKey;
	}
	
	static int[][] rotateKey(int[][] src) {
		int[][] rotatedKey = new int[m][m];
		int y = m - 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				rotatedKey[j][y] = src[i][j]; // 90도 회전
			}
			y--;
		}
		return rotatedKey;
	}
    
    static int[][] copyKey(int[][] src) {
		int[][] copy = new int[m][m];
		for (int i = 0; i < m; i++) {
        	for (int j = 0; j < m; j++) {
        		copy[i][j] = src[i][j]; // 열쇠 복사
        	}
        }
		return copy;
	}
}
