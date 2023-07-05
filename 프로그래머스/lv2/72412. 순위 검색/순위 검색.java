//package Programmers.Level_2.순위검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

class Solution {
    static HashMap<String, ArrayList<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for(int i = 0; i < info.length; i++){
            String[] arrInfo = info[i].split(" ");
            includeInfo(arrInfo, "", 0);
        }

        // value 의 list 들을 정렬
        for(String key : map.keySet())
            Collections.sort(map.get(key));

        //System.out.println(map + " \n");
        
        for(int i = 0; i < query.length; i++){
            String[] splitQuery = query[i].split(" ");
            String queryKey = "";
            int score = Integer.parseInt(splitQuery[splitQuery.length - 1]);

            for(int j = 0; j < splitQuery.length - 1; j++){
                if(!splitQuery[j].equals("and")){
                    queryKey += splitQuery[j];
                }
            }
            //System.out.println(queryKey);

            if(map.containsKey(queryKey)){
                answer[i] = binarySearch(queryKey, score);
            }else{
                answer[i] = 0;
            }
        }

        return answer;
    }

    int binarySearch(String queryKey, int score){
        ArrayList<Integer> list = map.get(queryKey);
        int s = 0;
        int e = list.size() - 1;

        while(s <= e){
            int mid = (s + e) / 2;

            if(score <= list.get(mid)){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }

        return list.size() - s;
    }

    // info[i] 가 포함되는 문장을 만들어서 map 에 넣음
    void includeInfo(String[] arrInfo, String str, int cnt){
        if(cnt == 4){
            ArrayList<Integer> list;
            int value = Integer.parseInt(arrInfo[4]);

            if(map.containsKey(str)){
                list = map.get(str);
            }else{
                list = new ArrayList<>();
            }

            list.add(value);
            map.put(str, list);

            return;
        }

        includeInfo(arrInfo, str + arrInfo[cnt], cnt + 1);  // 1. info[i]를 넣을 때
        includeInfo(arrInfo, str + "-", cnt + 1);           // 2. - 를 넣을 때
    }

}