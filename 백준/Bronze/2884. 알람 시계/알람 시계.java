import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int h;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
               
        if(m < 45){
            m += 15;    
            if(h == 0){
                h = 23;
            } else {
                h--;
            }
        } else {
            m -= 45;
        }
        
        
        System.out.println(h + " " + m);
    }

}