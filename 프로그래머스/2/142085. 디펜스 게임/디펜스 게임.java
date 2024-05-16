import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = k;
        int hp = n;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        if(k >= enemy.length) {
            return enemy.length;
        }

        for(int i = 0; i < k; i++) {
            pq.add(enemy[i]);
        }
        int minEnemy = pq.peek();

        for(int i = k; i < enemy.length; i++) {
            if(enemy[i] > minEnemy) {
                Integer prevMinEnemy = pq.poll();
                pq.add(enemy[i]);
                minEnemy = pq.peek();
                hp -= prevMinEnemy;
            } else {
                hp -= enemy[i];
            }

            // System.out.println("i : " + i + ", hp : " + hp);
            if(hp <= -1) {
                break;
            }

            // 막을 수 있다면 증가
            answer++;
        }

        return answer;
    }
}
