import java.util.*;

class Solution {
    public int solution(String[] lines) {
        List<long[]> events = new ArrayList<>();
        
        // 로그 파싱
        for (String line : lines) {
            String[] arr = line.split(" ");
            String[] time = arr[1].split("[:.]");
            long endMillis = (Long.parseLong(time[0]) * 3600 + Long.parseLong(time[1]) * 60) * 1000
                            + Long.parseLong(time[2]) * 1000
                            + Long.parseLong(time[3]);
            long durationMillis = (long) (Double.parseDouble(arr[2].replace("s", "")) * 1000) - 1;
            long startMillis = endMillis - durationMillis;
            events.add(new long[] {startMillis, endMillis});
        }
        
        // 정렬 (이벤트의 시작시간 기준)
        events.sort(Comparator.comparingLong(a -> a[0]));
        
        // 초당 최대 처리량 계산
        int max = 0;
        for (long[] event : events) {
            long start = event[0];
            long end = event[1];
            
            // 1초 구간에서 처리량 계산
            max = Math.max(max, countWithinRange(events, start, start + 1000 - 1));
            max = Math.max(max, countWithinRange(events, end, end + 1000 - 1));
        }

        return max;
    }

    private int countWithinRange(List<long[]> events, long start, long end) {
        int count = 0;
        for (long[] event : events) {
            long s = event[0];
            long e = event[1];
            // 로그가 1초 구간과 겹치는 경우 확인
            if (e >= start && s <= end) {
                count++;
            }
        }
        return count;
    }
}
