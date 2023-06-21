import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        
            //StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());        
            
            
            System.out.println(N + M);    
        
       
    }

}