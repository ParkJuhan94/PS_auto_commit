//package DAY03.P1202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static List<Integer> bag;
    static List<Jewel> jewel;
    static PriorityQueue<Long> price;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/DAY03/P1202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bag = new ArrayList<>();
        jewel = new ArrayList<>();
        price = new PriorityQueue<Long>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewel.add(new Jewel(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        // 1. 가방 오름차순 / 보석 무게 오름차순
        Collections.sort(bag);
        Collections.sort(jewel);

        // 2. 가방에 넣을 수 있는 보석 중 : 보석 무게 배열에서 포인터 사용
        // 비싼 보석 : pq
        long sum = 0;
        int bagPos = 0;
        int jewelPos = 0;
        while (true){
            // 남은 가방이 없으면 탈출!!
            if(bagPos >= bag.size()) break;

            //  보석을 다 담았다면
            if (jewelPos >= jewel.size()) {
                // 담을 수 있는 보석이 있으면
                if (!price.isEmpty()) {
                    sum += price.poll();
                }
                bagPos++;
            }
            //  bagPos 번째 가방에 담을 수 있는 보석 pq에 넣기
            else if (bag.get(bagPos) >= jewel.get(jewelPos).weight) {
                price.add((long) jewel.get(jewelPos).price);    //  보석은 넣는 즉시 최대힙에 들어감
                jewelPos++;
            }
            //  bagPos 번째 가방에 담을 수 있는 jewelPos 번부터의 보석이 없다면
            else {
                // 담을 수 있는 보석이 있으면 담고 가방++
                if (!price.isEmpty()) {
                    sum += price.poll();
                }
                bagPos++;
            }
        }

        System.out.println(sum);
    }
}

class Jewel implements Comparable<Jewel> {
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel o) {
        return weight - o.weight;
    }

}