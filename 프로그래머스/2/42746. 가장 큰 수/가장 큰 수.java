import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 숫자를 문자열로 변환하여 배열에 저장
        String[] arr = Arrays.stream(numbers)
                             .mapToObj(String::valueOf)
                             .toArray(String[]::new);

        // Comparator를 사용하여 두 숫자를 결합했을 때 큰 순서대로 정렬
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 모든 숫자가 0인 경우 결과는 "0"
        if (arr[0].equals("0")) {
            return "0";
        }

        // 정렬된 숫자들을 순서대로 이어 붙여서 결과 반환
        StringBuilder sb = new StringBuilder();
        for (String num : arr) {
            sb.append(num);
        }
        return sb.toString();
    }
}
