import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 숫자를 문자열 배열로 변환
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 문자열 정렬: (s1 + s2)와 (s2 + s1)를 비교
        Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // 정렬 결과가 모두 0인 경우, "0"을 반환
        if (arr[0].equals("0")) {
            return "0";
        }

        // 정렬된 문자열을 연결하여 결과 반환
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }

        return sb.toString();
    }
}
