class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;

        for(int i = 0; i < sizes.length; i++) {
            // 가로를 길게 미리 눕히기
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }

        for(int i = 0; i < sizes.length; i++) {
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }
        
        return maxW * maxH;
    }
}
