import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] cntWeight = new long[1001];
        long[] mulWeight = new long[4004];
        
        for (int weight : weights) {
            long temp = cntWeight[weight];
            int m2 = weight * 2;
            int m3 = weight * 3;
            int m4 = weight * 4;
            
            if(temp > 0) {  //이미 전에도 등장
                answer += temp;
                answer += mulWeight[m2] - temp;
                answer += mulWeight[m3] - temp;
                answer += mulWeight[m4] - temp;
            }
            else {  //처음 등장
                answer += mulWeight[m2];
                answer += mulWeight[m3];
                answer += mulWeight[m4];
            }
            cntWeight[weight]++;
            mulWeight[m2]++;
            mulWeight[m3]++;
            mulWeight[m4]++;
        
        }
        
        return answer;
    }
}
