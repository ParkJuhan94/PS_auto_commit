import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(arr[0]);
        int tmp = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != tmp){
                list.add(arr[i]);
            }
            tmp = arr[i];
        }
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
            


        return answer;
    }
}