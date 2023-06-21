
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int N, K, i, selectedCount = 0, max = 0;
    static String[] words;
    static int res = 0;
    static int ch[] = new int[26];

    public static void main(String[] args) throws FileNotFoundException {
        //System.setIn(new FileInputStream("src/DAY01/P1062/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        words = new String[N];

        if(K<5) {
            System.out.println(0);
            return;
        }else if(K==26) {
            System.out.println(N);
            return;
        }else{
            ch['a' - 'a'] = 1;
            ch['n' - 'a'] = 1;
            ch['t' - 'a'] = 1;
            ch['c' - 'a'] = 1;
            ch['i' - 'a'] = 1;

            //for (i = 0; i < N; i++) words[i] = sc.next();
            //입력받을 때 a n t i c를 공백으로 치환해서 속도 향상
            for(i = 0; i < N; i++){
                words[i] = sc.next().replaceAll("[antic]", "");
            }

            selectedCount = 5;
            max = countWords();

            for(i = 0 ; i < 26; i++){
                if(ch[i] == 0) dfs(i);
            }
        }

        System.out.println(max);
    }

    //반드시 main 처럼 static 으로 만든다.
    static void dfs(int idx){
        //1. 체크인하면서 count 증가
        ch[idx] = 1;
        selectedCount++;

        //2. 목적지인가?
        if(selectedCount == K){
            max = Math.max(max, countWords());
        }else{
            //3. 아니면 연결된 곳을 순회
            for(int i = idx + 1; i <= 25; i++){
                //4. 갈 수 있는가?
                if(ch[i] == 0){
                    //5. 간다
                    dfs(i);
                }
            }    
        }
        
        //6. 체크아웃하면서 count 감소
        ch[idx] = 0;
        selectedCount--;
    }

    static int countWords(){
        int cnt = 0;
        for(int n = 0; n < N; n++){
            boolean isPossible = true;
            String word = words[n];

            for(int i = 0; i < word.length(); i++){
                if(ch[word.charAt(i) - 'a'] == 0){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) cnt++;
        }
        return cnt;
    }
}