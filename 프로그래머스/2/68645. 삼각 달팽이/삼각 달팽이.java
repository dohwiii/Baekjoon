import java.util.*;

class Solution {
    static List<Integer>[] list;

    public int[] main(int n) {
        // 각 층을 저장할 리스트 초기화
        list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        int[] result = solution(n);
        return result;
    }
    public int[] solution(int n) {
        // 삼각형 배열을 위한 2차원 배열 생성
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }

        int num = 1;       // 채워넣을 숫자
        int x = -1, y = 0; // 현재 위치
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {        // 아래로 내려가는 경우
                    x++;
                } else if (i % 3 == 1) { // 오른쪽으로 가는 경우
                    y++;
                } else {                 // 위로 올라가는 경우
                    x--;
                    y--;
                }
                triangle[x][y] = num++; // 숫자 채워넣기
            }
        }

        // 결과 배열에 숫자 채우기
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                resultList.add(triangle[i][j]);
            }
        }

        // List를 배열로 변환하여 반환
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
