import java.util.*;

class Solution {
 
    
    public String solution(String s) {
    
    s = s.toLowerCase(); //처음부터 다 소문자로

		StringTokenizer st = new StringTokenizer(s, " ", true);
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			// 만약 단어가 공백이면 그대로 출력해주고
			if (word.equals(" "))
				sb.append(word);
			else { //아니라면 첫글자 대문자 변환해주기
				sb.append(word.substring(0, 1).toUpperCase() + word.substring(1));
			}
		}
		return sb.toString();
	}

}