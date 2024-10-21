import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dSquare = (long) d * d;

        for (int x = 0; x <= d; x += k) {
            // x에 따른 최대 y 값을 구해서 y에 대한 루프 범위를 제한
            long maxYSquare = dSquare - (long) x * x;
            int maxY = (int) Math.sqrt(maxYSquare);
            
            answer += (maxY / k) + 1; // y 값이 k의 배수일 때만 포함
        }
        
        return answer;
    }
}
