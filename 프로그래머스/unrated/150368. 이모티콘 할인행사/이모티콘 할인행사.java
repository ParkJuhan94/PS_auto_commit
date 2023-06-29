//package Programmers.Level_2.이모티콘할인행사;

class Solution {
    int[] percentage = {40, 30, 20, 10};
    int[] emoticons;
    int[][] users;
    int join;
    int sales;
    int resJoin = 0;       // 총 서비스 가입자
    int resSales = 0;      // 총 판매액
    int[][] prices;
    int[] testPrices;
    int[][] ch;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        this.users = users;
        this.emoticons = emoticons;
        prices = new int[emoticons.length][4];
        ch = new int[emoticons.length][4];
        testPrices = new int[emoticons.length];

        pre();
        search(0);

        answer[0] = resJoin;
        answer[1] = resSales;

        return answer;
    }

    // 이모티콘의 인덱스
    void search(int L){
        if(L == emoticons.length){
            join = 0;
            sales = 0;

            for (int i = 0; i < users.length; i++) {
                int userPay = 0;

                for(int j = 0; j < emoticons.length; j++){
                    int tmpPercentage = (emoticons[j] - testPrices[j]) * 100 / emoticons[j];
                    if(tmpPercentage >= users[i][0]){
                        userPay += testPrices[j];
                    }
                }

                if (joinService(users[i], userPay)) {
                    join++;
                    userPay = 0;
                }

                sales += userPay;
            }

            // 서비스 가입자와 총 판매액을 갱신
            if(join > resJoin){
                resJoin = join;
                resSales = sales;
            }else if(join == resJoin){
                if(sales >= resSales){
                    resSales = sales;
                }
            }

            return;
        }

        for(int j = 0; j < 4; j++){
            testPrices[L] = prices[L][j];
            search(L + 1);
        }
    }

    void pre(){
        // 각 할인율에 따른 이모티콘 최종가격 초기화
        for(int e = 0; e < emoticons.length; e++){
            for(int p = 0; p < 4; p++){
                prices[e][p] = emoticons[e] * (100 - percentage[p]) / 100;
            }
        }
    }

    boolean joinService(int[] user, int sumPay){
        if(sumPay >= user[1]){
            return true;
        }else{
            return false;
        }
    }
}