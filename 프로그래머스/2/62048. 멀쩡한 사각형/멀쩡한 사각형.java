import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 0;  
        double prev = h;   //y절편
        
        for(long i=1; i<=w; i++) {
            double temp = -1 * h * i / (double) w + h;
            double diff = prev - Math.floor(temp);
            answer += diff;
            prev = Math.ceil(temp);
        }
        
        return (long) w*h - answer;
    }
}