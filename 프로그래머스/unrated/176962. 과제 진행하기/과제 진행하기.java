import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Plan implements Comparable<Plan>{
    String name;
    int start;
    int playtime;       // 남은 잔여시간의 의미도 됨

    public Plan(String name, int start, int playtime) {
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }

    @Override
    public int compareTo(Plan o) {
        return this.start - o.start;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", playtime=" + playtime +
                '}';
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        ArrayList<Plan> planList = new ArrayList<>();
        int ansIdx = 0;

        for(int i = 0; i < plans.length; i++){
            String[] times = plans[i][1].split(":");
            int h = Integer.parseInt(times[0]);
            int m = Integer.parseInt(times[1]);
            int start = h * 60 + m;

            planList.add(new Plan(plans[i][0],
                    start, Integer.parseInt(plans[i][2])));
        }

        // 시작 늦은 순으로 정렬
        Collections.sort(planList, Collections.reverseOrder());

        Stack<Plan> stack = new Stack<>();    // 시작한 적 없는 과제들
        Stack<Plan> stackTmp = new Stack<>(); // 중단한 과제들

        for(int i = 0; i < planList.size(); i++){
            stack.push(planList.get(i));
        }

        // 현재 시각을 첫번째 과제 시작 시간으로 초기화
        int now = planList.get(planList.size() - 1).start;

        while(!stack.isEmpty())
        {
            Plan cur = stack.pop();

            // 만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면,
            // 새로 시작해야 하는 과제부터 진행합니다.

            if(cur.start == now){
                // 새로 시작하는 과제를 시작
                if(stack.size() == 0){
                    // 새로 시작할 과제가 더 이상 없을 때
                    answer[ansIdx++] = cur.name;

                    while(!stackTmp.isEmpty()){
                        Plan curTmp = stackTmp.pop();
                        answer[ansIdx++] = curTmp.name;
                    }
                }else{
                    // 새로 시작할 과제가 더 남았을 때
                    Plan next = stack.peek();

                    if(cur.start + cur.playtime <= next.start){
                        // 쭉
                        now += cur.playtime;
                        answer[ansIdx++] = cur.name;
                    }else{
                        // 중간에 끊길 때
                        cur.playtime -= next.start - cur.start;
                        now += next.start - cur.start;
                        stackTmp.push(cur);
                    }
                }
            }else{
                // 멈춰둔 과제를 시작
                stack.push(cur);    // 뺏던 걸 다시 넣어주는게 중요!!

                if(stackTmp.isEmpty()){
                    // 멈춰둔 과제가 없으면 -> 시작할 과제로 넘어갈 수 있도록 현재 시간 조정
                    now = cur.start;
                }else{
                    // 멈춰둔 과제가 있으면
                    while(!stackTmp.isEmpty())
                    {
                        Plan curTmp = stackTmp.pop();

                        if(now + curTmp.playtime <= cur.start){
                            // 쭉
                            now += curTmp.playtime;
                            answer[ansIdx++] = curTmp.name;
                        }else{
                            // 중간에 끊길 때
                            curTmp.playtime -= (cur.start - now);
                            now += (cur.start - now);
                            stackTmp.push(curTmp);
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }
}