import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        String[] now = today.split("\\.");
        int nYear = Integer.parseInt(now[0]);
        int nMon = Integer.parseInt(now[1]);
        int nDay = Integer.parseInt(now[2]);

        for (String t : terms) {
            String[] arr = t.split(" ");
            termsMap.put(arr[0], Integer.parseInt(arr[1]));
        }
        int index = 0;
        for (String p : privacies) {
            String[] arr = p.split(" ");
            String[] date = arr[0].split("\\.");
            if (!termsMap.containsKey(arr[1])) {
                throw new IllegalArgumentException("유효하지 않은 약관 종류: " + arr[1]);
            }
            int expiration = termsMap.get(arr[1]); // 유효기간
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);

            int endMonth = month + expiration;
            year += (endMonth - 1) / 12;
            endMonth = (endMonth - 1) % 12 + 1;

            if (day == 1) { // 1일이라면 이전 달로 넘어감
                endMonth -= 1;
                if (endMonth == 0) {
                    endMonth = 12;
                    year -= 1;
                }
                day = 28;
            } else {
                day -= 1;
            }

            index++;
            if (nYear > year || 
                (nYear == year && nMon > endMonth) || 
                (nYear == year && nMon == endMonth && nDay > day)) {
                answer.add(index);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
