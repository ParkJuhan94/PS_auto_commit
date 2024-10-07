import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
         // delete_list를 HashSet으로 변환
        HashSet<Integer> deleteSet = new HashSet<>();
        for (int num : delete_list) {
            deleteSet.add(num);
        }
        
        // arr에서 delete_list에 없는 원소만 결과 배열에 추가
        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            if (!deleteSet.contains(num)) {
                result.add(num);
            }
        }
        
        // 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}