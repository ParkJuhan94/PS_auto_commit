class Solution {
	public int solution(String s) {
		int answer = 0;
		int len = s.length();

		for (int i = 0; i < len; i++) {
			int countEqualsOdd = 1;
			int countEqualsEven = 0;

			// 홀수개의 팰린드롬
			for (int j = 1; j <= len / 2; j++) {
				int prev = i - j;
				int next = i + j;

				if (prev < 0 || next > len - 1) {    // 인덱스 에러 방지
					break;
				}
				
				if (s.charAt(prev) == s.charAt(next)) {
					countEqualsOdd += 2;
				} else {
					break;
				}
			}
			
			// 짝수개의 팰린드롬
			for (int j = 1; j <= len / 2; j++) {
				int prev = i - j;
				int next = i + j - 1;

				if (prev < 0 || next > len - 1) {    // 인덱스 에러 방지
					break;
				}

				if (s.charAt(prev) == s.charAt(next)) {
					countEqualsEven += 2;
				} else {
					break;
				}
			}
			

			answer = Math.max(answer, countEqualsOdd);
			answer = Math.max(answer, countEqualsEven);
		}

		return answer;
	}
}
