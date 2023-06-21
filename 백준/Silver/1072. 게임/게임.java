
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int X,Y;
    static int percent;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/DAY02/P1072/input.txt"));

        BufferedReader br = br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        percent = getPercent(X,Y);

        int answer = -1;
        int lt = 0;
        int rt = (int)1e9;

        while(lt <= rt){
            int mid = (lt + rt) / 2;
            
            if(getPercent(X + mid, Y + mid) > percent){
                answer = mid;
                rt = mid - 1;
            }else{
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static int getPercent(int x, int y) {
        if(x == 0){
            return -1;
        }else{
            return (int) ((long) y * 100 / x);
        }
    }
}
