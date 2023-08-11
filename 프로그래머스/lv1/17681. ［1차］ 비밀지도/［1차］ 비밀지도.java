class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        String[] strArr1 = new String[n];
        String[] strArr2 = new String[n];
        for(int i = 0; i < n; i++){
            // 앞자리 0 붙여서 넣기
            String str1 = Integer.toString(arr1[i], 2);
            String str2 = Integer.toString(arr2[i], 2);
            while(str1.length() != n){
                str1 = "0" + str1;
            }
            while(str2.length() != n){
                str2 = "0" + str2;
            }
            
            strArr1[i] = str1;
            strArr2[i] = str2;
        }

        int idx = 0;
        StringBuilder sb;
        for(int i = 0; i < n; i++){
            sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(strArr1[i].charAt(j) == '0' && strArr2[i].charAt(j) == '0'){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            answer[idx++] = sb.toString();
        }

        return answer;
    }
}