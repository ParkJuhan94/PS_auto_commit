class Solution {
	public String[] solution(String[] s) {
		String[] answer = new String[s.length];

		for (int i = 0; i < s.length; i++) {
			String ans = solve(s[i]);
			answer[i] = ans;
		}

		return answer;
	}

	public String solve(String s) {
		StringBuilder res = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (res.length() >= 2 && res.charAt(res.length() - 2) == '1'
				&& res.charAt(res.length() - 1) == '1' && c == '0') {
				temp.append("110");
				res.delete(res.length() - 2, res.length());
			} else {
				res.append(c);
			}
		}

		if (temp.length() > 0) {
			if (res.indexOf("0") == -1) {		//0이 없으면
				res.insert(0, temp);	//맨앞에 넣는다
			} else {
				int idx = res.lastIndexOf("0");
				res.insert(idx + 1, temp);
			}
		}

		return res.toString();
	}
}
