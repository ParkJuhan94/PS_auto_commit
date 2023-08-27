//package Programmers.Level_3.징검다리건너기;

// N = 20만
// M = 2억
// O(N * logM)

class Solution {

    int[] stones;
    int M;
    int k;

    public int solution(int[] stones, int k) {
        int answer = 0;
        this.stones = stones;
        this.k = k;
        M = stones.length;

        int l = 1;
        int r = 200_000_000;

        while(l <= r){
            int mid = (l + r) / 2;

            if(isPossible(mid)){
                l = mid + 1;
                answer = Math.max(answer, mid);
            }else{
                r = mid - 1;
            }
        }

        return answer;
    }

    // 해당 숫자의 사람이 건널 수 있는가?
    boolean isPossible(int n) {
        int[] copyStones = new int[stones.length];
        for(int i = 0; i < stones.length; i++){
            copyStones[i] = stones[i];
        }

        int cnt = 0;    // 0이 되어버리는 디딤돌의 수

        for (int copyStone : copyStones) {
            if(copyStone < n){
                cnt++;
                if(cnt == k){
                    return false;
                }
            }else{
                cnt = 0;
            }
        }

        return true;
    }

//    boolean isPossible(int n) {
//        int[] copyStones = new int[stones.length];
//        for(int i = 0; i < stones.length; i++){
//            copyStones[i] = stones[i];
//        }
//
//        for(int i = 0; i < n; i++){
//            int cnt = 0;    // 건너뛴 돌의 수
//
//            for(int j = 0; j < copyStones.length; j++){
//                if(copyStones[j] > 0) {
//                    copyStones[j]--;
//                    cnt = 0;
//                }else{
//                    cnt++;
//                    if(cnt == k){
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return true;
//    }
}