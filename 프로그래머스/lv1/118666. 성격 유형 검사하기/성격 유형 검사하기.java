//package Programmers.Level_1.성격유형검사하기;

class Solution {
    // RT CF JM AN
    int[][] scores = new int[4][2];

    public String solution(String[] survey, int[] choices) {
        String answer = "";


        for(int i = 0; i < survey.length; i++){
            String cur = survey[i];
            int choice = choices[i];
            int sector = -1;
            boolean reverse = false;
            
            if(cur.charAt(0) == 'R' || cur.charAt(0) == 'T'){
                sector = 0;    
            }
            if(cur.charAt(0) == 'C' || cur.charAt(0) == 'F'){
                sector = 1;
            }
            if(cur.charAt(0) == 'J' || cur.charAt(0) == 'M'){
                sector = 2;
            }
            if(cur.charAt(0) == 'A' || cur.charAt(0) == 'N'){
                sector = 3;
            }
            
            if(cur.charAt(0) == 'T' || cur.charAt(0) == 'F' ||
                    cur.charAt(0) == 'M' ||cur.charAt(0) == 'N'){
                reverse = true;
            }

            search(cur, choice, sector, reverse);
        }

        if(scores[0][0] < scores[0][1]){
            answer += "T";
        }else{
            answer += "R";
        }

        if(scores[1][0] < scores[1][1]){
            answer += "F";
        }else{
            answer += "C";
        }

        if(scores[2][0] < scores[2][1]){
            answer += "M";
        }else{
            answer += "J";
        }

        if(scores[3][0] < scores[3][1]){
            answer += "N";
        }else{
            answer += "A";
        }

        return answer;
    }

    void search(String cur, int choice, int sector, boolean reverse){
        if(!reverse){
            if(choice > 4){
                scores[sector][1] += choice - 4;   
            }else{
                scores[sector][0] += 4 - choice;
            }
        }else{
            if(choice > 4){
                scores[sector][0] += choice - 4;
            }else{
                scores[sector][1] += 4 - choice;
            }
        }
    }
}