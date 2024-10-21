import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[col-1] == b[col-1]) {
                    return b[0] - a[0]; //기본키 기준 내림차순
                }
                return a[col-1] - b[col-1];
            }
        });

        for(int i = row_begin - 1; i <= row_end -1 ; i++) {
            int sum = 0;
            
            for(int j = 0; j < data[0].length; j++) {
                sum += (data[i][j] % (i + 1));
            }
            answer = answer ^ sum;
        }
        return answer;
    }
}