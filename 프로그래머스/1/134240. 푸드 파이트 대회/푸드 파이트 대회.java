class Solution {
    public String solution(int[] food) {
        StringBuilder leftSide = new StringBuilder();
        
        // 왼쪽 음식 배치 생성
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            for (int j = 0; j < count; j++) {
                leftSide.append(i);
            }
        }
        
        // 오른쪽 음식은 왼쪽 음식의 뒤집은 형태
        String rightSide = new StringBuilder(leftSide).reverse().toString();
        return leftSide.toString() + "0" + rightSide;
    }
}
