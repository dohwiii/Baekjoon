import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long W = (long) w;
        long H = (long) h;
        
        // 최대공약수(GCD) 계산
        long gcd = gcd(W, H);
        
        // 전체 격자 개수에서 대각선이 지나는 격자 개수를 뺌
        return W * H - (W + H - gcd);
    }
    
    // 유클리드 호제법을 사용한 GCD 계산
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
