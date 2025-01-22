import java.util.*;
class Solution {
    public int[] solution(String s) {
        // 1. 양 끝 {{, }} 제거 및 그룹화
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("},\\{");

        // 2. 길이 기준으로 정렬
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        // 3. 숫자 중복 확인용 Set 및 결과 저장용 List
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        // 4. 그룹별 숫자 처리
        for (String group : arr) {
            for (String num : group.split(",")) {
                int value = Integer.parseInt(num);
                if (set.add(value)) { // Set에 없으면 추가 및 결과에 저장
                    result.add(value);
                }
            }
        }

        // 5. 결과 변환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
