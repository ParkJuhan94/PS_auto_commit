//package Programmers.Level_1.신규아이디추천;

class Solution {
    public String solution(String new_id) {
        String tmp = "";
        String remains = "abcdefghijklmnopqrstuvwxyz1234567890-_.";

        new_id = new_id.toLowerCase();
        for(int i = 0; i < new_id.length(); i++){
            for(char c : remains.toCharArray()){
                if(new_id.charAt(i) == c){
                    tmp += Character.toString(c);
                }
            }
        }
        new_id = tmp;

         while(new_id.contains("..")){
            new_id = new_id.replace("..", ".");    
        }

        if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(1);
        }
        if(new_id.length() >= 1){
            if(new_id.charAt(new_id.length() - 1) == '.'){
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }


       if(new_id.length() == 0){
           new_id = "a";
       }

       if(new_id.length() >= 16){
           new_id = new_id.substring(0, 15);
       }
       if(new_id.charAt(new_id.length() - 1) == '.'){
           new_id = new_id.substring(0, new_id.length() - 1);
       }

       while(new_id.length() <= 2){
           new_id += new_id.charAt(new_id.length() - 1);
       }

        return new_id;
    }
}