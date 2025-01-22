import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int index = 0;
        
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                int value = (i - 1) * columns + j;
                map[i-1][j-1] = value; 
            }
        }
        
        for(int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            
            int prev = map[x1][y1];
            int minVal = prev;

            //상단 행 이동
            for(int y=y1 + 1; y<=y2; y++) {
                int temp = map[x1][y];
                map[x1][y] = prev;
                prev = temp;
                minVal = Math.min(minVal, prev);
            }
            //오른쪽 열 이동
            for(int x=x1 + 1; x<=x2; x++) {
                int temp = map[x][y2];
                map[x][y2] = prev;
                prev = temp;
                minVal = Math.min(minVal, prev);
            }
            //하단 행 이동
            for(int i=y2-1; i>=y1; i--) {
                int temp = map[x2][i];
                map[x2][i] = prev;
                prev = temp;
                minVal = Math.min(minVal, prev);
            }
            //왼쪽 열 이동
            for(int i=x2-1; i>=x1; i--) {
                int temp = map[i][y1];
                map[i][y1] = prev;
                prev = temp;
                minVal = Math.min(minVal, prev);
            }
            answer[index++] = minVal;
        }

        
        return answer;
    }
}