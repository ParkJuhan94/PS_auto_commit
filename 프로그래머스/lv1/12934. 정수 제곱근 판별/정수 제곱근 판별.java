import java.util.*;
import java.io.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        Double d = Math.sqrt(n);        
    
                
        if(d == d.intValue()){
            answer = (long)Math.pow(d.intValue() + 1, 2);
        }else{
            answer = -1;
        }
        
        return answer;
    }
}
