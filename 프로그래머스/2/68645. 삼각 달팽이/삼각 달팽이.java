import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int[][] map = new int[n][n];
        
        int x = -1, y = 0;
        int num = 1;
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(i%3 == 0) {  //아래
                    x++;
                }
                else if(i%3 == 1) { //오른쪽
                    y++;
                }
                else if(i%3 == 2) { //위
                    x--;
                    y--;
                }
                map[x][y] = num++;
            }
            
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0;j<n;j++) {
                if(map[i][j] != 0) {
                    result.add(map[i][j]);
                }
                if(map[i][j] == 0) {
                    break;
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}