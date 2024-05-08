import java.util.LinkedList;
import java.util.Queue;

class Solution {
	Queue<String> cacheQ = new LinkedList<>();

	public int solution(int cacheSize, String[] cities) {
		int answer = 0;

		for (int i = 0; i < cities.length; i++) {
			String city = cities[i].toLowerCase();

			// 캐쉬에 있는 도시이름인지 판단
			if (cacheQ.contains(city)) {
				answer++;
				// 앞으로 빼주기
				int qSize = cacheQ.size();
				Queue<String> tempQ = new LinkedList<>();
				
				while(!cacheQ.isEmpty()){
					tempQ.add(cacheQ.poll());
				}
				
				while (qSize-- > 0) {
					String cur = tempQ.poll();
					if(!cur.equals(city)){
						cacheQ.add(cur);
					}
				}
				cacheQ.add(city);
				
				continue;
			} else {
				answer += 5;
			}

			// 캐쉬에 넣는다.
			cacheQ.add(city);

			// 캐쉬 사이즈 넘어가면 LRU
			if (cacheQ.size() > cacheSize) {
				cacheQ.poll();
			}
		}

		return answer;
	}
}
