import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesCount = new HashMap<>();

        for (String[] clothe : clothes) {
            clothesCount.put(clothe[1], clothesCount.getOrDefault(clothe[1], 0) + 1);
        }

        int combinations = 1;  // 조합의 수를 저장하는 변수
        for (String key : clothesCount.keySet()) {
            combinations *= clothesCount.get(key) + 1;  // 각 종류별 (의류 수 + 1)을 곱함
        }

        return combinations - 1;    // 모든 종류의 의류를 하나도 안 입는 경우를 제외
    }
}