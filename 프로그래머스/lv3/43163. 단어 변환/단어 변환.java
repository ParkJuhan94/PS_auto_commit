class Solution {

    int ans = Integer.MAX_VALUE;
    String begin, target;
    String[] words;
    int[] ch;

    public int solution(String begin, String target, String[] words) {

        this.begin = begin;
        this.target = target;
        this.words = words;
        ch = new int[words.length];

        dfs(0, begin, 0);
        
        if(ans == Integer.MAX_VALUE)
            return 0;

        return ans;
    }

    void dfs(int L, String cur, int cnt) {
        if(cur.equals(target)){
            ans = Math.min(ans, cnt);
            return;
        }

        if(L == words.length){
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(ch[i] == 0 && isPossible(cur, words[i])){
                ch[i] = 1;
                dfs(L + 1, words[i], cnt + 1);
                ch[i] = 0;
            }
        }
    }

    // 두 문자열이 한개의 알파벳만 바꿔서 같아지는지 반환
    boolean isPossible(String str1, String str2){
        int diffCnt = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                diffCnt++;
            }
        }

        if(diffCnt <= 1){
            return true;
        }else{
            return false;
        }
    }
}