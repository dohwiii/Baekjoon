import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        Map<String, Integer> map = Map.of("code", 0, "date", 1, "maximum", 2, "remain", 3);

        int standardIndex = map.get(ext);

        // 데이터 필터링
        for (int[] d : data) {
            if (ext.equals("date")) {
                // 날짜 필터링: 숫자로 비교
                if (d[1] < val_ext) {
                    list.add(d);
                }
            } else {
                // 다른 필드 필터링
                if (d[standardIndex] < val_ext) {
                    list.add(d);
                }
            }
        }

        // 정렬
        int sortIndex = map.get(sort_by);
        list.sort(Comparator.comparingInt(a -> a[sortIndex]));

        // 결과를 배열로 변환
        return list.toArray(new int[0][]);
    }
}