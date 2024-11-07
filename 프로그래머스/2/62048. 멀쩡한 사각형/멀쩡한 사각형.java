import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        double slope = -1 * h / (double) w;     
        double prev = h;   //y절편
        
        for(long i=1; i<=w; i++) {
            double temp = -1 * h * i / (double) w + h;
            double diff = prev - Math.floor(temp);
            answer += diff;
            prev = Math.ceil(temp);
            
            // System.out.println(i);
            // System.out.println(temp);
            // System.out.println(diff);
            // System.out.println(prev);
            // System.out.println();
        }
        
        return (long) w*h - answer;
    }
}